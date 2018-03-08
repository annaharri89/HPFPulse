package org.humanitypreservationfoundation.pulse.classes;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import org.humanitypreservationfoundation.pulse.enums.StateEnum;

import java.util.List;

/**
 * Created by ETASpare on 3/6/2018.
 */

public class Resource implements Parcelable {

    private long mId; //todo get mID from parcel when database is set up // (SEE HOW youKNOWwhat GETS ITS ID)
    private String mName;
    private String mUrl;
    private String mPhoneNumber;
    private StateEnum mStateEnum;
    private String mStateName;
    private String mCategory;

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
        dest.writeString(this.mCategory);
        dest.writeLong(this.mId);
        dest.writeString(this.mName);
        dest.writeString(this.mPhoneNumber);
        dest.writeSerializable(this.mStateEnum);
        dest.writeString(this.mStateName);
        dest.writeString(this.mUrl);
    }

    /**
     * This field is needed for Android to be able to create new objects, individually or as arrays
     */
    public static final Parcelable.ClassLoaderCreator<Resource> CREATOR = new Parcelable.ClassLoaderCreator<Resource>()
    {

        @Override
        public Resource createFromParcel(Parcel source)
        {
            return createFromParcel(source, null);
        }

        @Override
        public Resource createFromParcel(Parcel source, ClassLoader loader)
        {
            return new Resource(source, loader);
        }

        @Override
        public Resource[] newArray(int size)
        {
            return new Resource[size];
        }
    };

    /**
     * Parcelable Resource's constructor.
     */
    public Resource (Parcel in, ClassLoader loader) {
        this.mCategory = in.readString();
        this.mId = in.readLong();
        this.mName = in.readString();
        this.mPhoneNumber = in.readString();
        this.mStateEnum = (StateEnum) in.readSerializable();
        this.mStateName = in.readString();
        this.mUrl = in.readString();
    }

    public Resource() {
    }

    //todo remove: only needed for dummy data
    public Resource(String category, Long id, String name, String phone, StateEnum stateEnum, String url) {
        this.mCategory = category;
        this.mId = id;
        this.mName = name;
        this.mPhoneNumber = phone;
        this.mStateEnum = stateEnum;
        this.mStateName = this.mStateEnum.toStringName();
        this.mUrl = url;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public long getId() {
        return mId;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.mPhoneNumber;
    }

    public StateEnum getStateEnum() {
        return this.mStateEnum;
    }

    public String getStateName() {
        return this.mStateName;
    }

    public String getUrl() {
        return this.mUrl;
    }
}
