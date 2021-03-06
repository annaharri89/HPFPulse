/*
        Copyright 2018 The Humanity Preservation Foundation

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package org.humanitypreservationfoundation.pulse.classes;

import android.content.Context;
import android.graphics.Region;
import android.os.Parcel;
import android.os.Parcelable;

import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;

import org.humanitypreservationfoundation.pulse.enums.StateEnum;
import org.humanitypreservationfoundation.pulse.interfaces.ITimeZone;
import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TimeZone implements ITimeZone, Parcelable {
    private Context mContext;
    private List<State> mStates = new ArrayList<>();
    private String mName;
    private String mDescription;
    private String mCode;
    private TimeZoneEnum mTimeZoneEnum;
    private String mColor;
    private String mColorCode;

    private static final String COLOR_PREFIX = "map_";

    /* Defines the kind of object that will be parcelled */
    @Override
    public int describeContents() {
        return 0;
    }

    /*
     Actual object serialization happens here, Write object content
     to parcel, reading should be done according to this write order
    */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.mStates);
        dest.writeString(this.mName);
        dest.writeString(this.mDescription);
        dest.writeString(this.mCode);
        dest.writeSerializable(this.mTimeZoneEnum);
        dest.writeString(this.mColor);
        dest.writeString(this.mColorCode);
    }

    /**
     * This field is needed for Android to be able to create new objects, individually or as arrays
     */
    public static final Parcelable.ClassLoaderCreator<TimeZone> CREATOR = new Parcelable.ClassLoaderCreator<TimeZone>()
    {

        @Override
        public TimeZone createFromParcel(Parcel source)
        {
            return createFromParcel(source, null);
        }

        @Override
        public TimeZone createFromParcel(Parcel source, ClassLoader loader)
        {
            return new TimeZone(source, loader);
        }

        @Override
        public TimeZone[] newArray(int size)
        {
            return new TimeZone[size];
        }
    };



    /**
     * Parcelable TimeZone's constructor.
     */
    public TimeZone (Parcel in, ClassLoader loader) {
        this.mStates = (List<State>) in.readArrayList(loader);
        this.mName = in.readString();
        this.mDescription = in.readString();
        this.mCode = in.readString();
        this.mTimeZoneEnum = (TimeZoneEnum) in.readSerializable();
        this.mColor = in.readString();
        this.mColorCode = in.readString();
    }

    public TimeZone (Context context, String colorCode, TimeZoneEnum timeZoneEnum, List<StateEnum> timeZoneStates, VectorMasterDrawable USMap) {
        this.mContext = context;
        this.mTimeZoneEnum = timeZoneEnum;
        this.mCode = timeZoneEnum.toStringCode();
        for (StateEnum stateEnum : timeZoneStates) {
            State state = new State(stateEnum, USMap);
            this.mStates.add(state);
        }
        this.mName = timeZoneEnum.toStringName();
        this.mDescription = this.getStrResource("_description");
        this.mColorCode = colorCode;
        this.mColor = this.getClrResource(this.mColorCode);
        if (!this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) { // needed because the ALL timezone shouldn't be seen
            this.setFillColor();
        }
    }

    public List<State> getStates() {
        return this.mStates;
    }

    public State getState(String stateCode) {
        for (State state : this.getStates()) {
            if (state.getCode().equals(stateCode)) {
                return state;
            }
        }
        return null;
    }

    /**
     * Sets each of the time zone's state's resources. Uses a StateEnum to find the right state.
     * @param resourceMap
     */
    public void setResources(Map<StateEnum, List<Resource>> resourceMap) {
        for (State state : this.getStates()) {
            for (Map.Entry<StateEnum, List<Resource>> entry : resourceMap.entrySet())
                if (entry.getKey().equals(state.getEnum())) {
                    state.setResources(entry.getValue());
                }
        }
    }

    public List<Resource> getStateChildAbuseResources(String stateCode) {
        State state = this.getState(stateCode);
        return state.getChildAbuseResources();
    }

    public List<Resource> getStateBullyingResources(String stateCode) {
        State state = this.getState(stateCode);
        return state.getBullyingResources();
    }

    public List<Resource> getStateDomesticViolenceResources(String stateCode) {
        State state = this.getState(stateCode);
        return state.getDomesticViolenceResources();
    }

    public List<Resource> getAllStateResources(String stateCode) {
        State state = this.getState(stateCode);
        return state.getAllResources();
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getCode() {
        return this.mCode;
    }

    public TimeZoneEnum getEnum() {
        return this.mTimeZoneEnum;
    }

    public String getColorCode() {
        return  this.mColorCode;
    }

    public String getName() {
        return this.mName;
    }

    /**
     * Used to change the time zone's fill color. Called when highlighting or unhighlighting the
     * time zone
     */
    public void changeFillColor(String qualifier) {
        this.mColor = this.getClrResource(qualifier);
        setFillColor();
    }

    /**
     * Used to get time zone's description text
     */
    private String getStrResource(String qualifier) {
        int resourceId = this.mContext.getResources().getIdentifier(this.mCode + qualifier, "string", this.mContext.getPackageName());
        return this.mContext.getString(resourceId);
    }

    /**
     * Used to get time zone's fill color
     * @param qualifier
     * @return
     */
    private String getClrResource(String qualifier) {
        int resourceId = this.mContext.getResources().getIdentifier(COLOR_PREFIX + qualifier, "color", this.mContext.getPackageName());
        return this.mContext.getString(resourceId);
    }

    /**
     * Sets the fill color of each state in the time zone
     */
    private void setFillColor() {
        for (State state : this.mStates) {
            state.setFillColor(this.mColor);
        }
    }
}
