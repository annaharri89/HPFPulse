package org.humanitypreservationfoundation.pulse.classes;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Parcel;
import android.os.Parcelable;

import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;
import com.sdsmdg.harjot.vectormaster.models.PathModel;

import org.humanitypreservationfoundation.pulse.enums.StateEnum;
import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;
import org.humanitypreservationfoundation.pulse.interfaces.IState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ETASpare on 1/23/2018.
 */

public class State implements IState, Parcelable {

    private Context context;
    private String mCode;
    private String mName;
    private StateEnum mEnum;
    private VectorMasterDrawable vector; //todo remove
    private Path mPath;
    private PathModel mPathModel;
    private Region mRegion;

    //TODO test following
    private Resource mChildAbuseResource;
    private Resource mBullyingResource;
    private Resource mDomesticViolenceResource;

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
        dest.writeString(this.mCode);
        dest.writeString(this.mName);
        dest.writeSerializable(this.mEnum);
        dest.writeParcelable(this.mChildAbuseResource, flags);
        dest.writeParcelable(this.mBullyingResource, flags);
        dest.writeParcelable(this.mDomesticViolenceResource, flags);
    }

    /**
     * This field is needed for Android to be able to create new objects, individually or as arrays
     */
    public static final Parcelable.ClassLoaderCreator<State> CREATOR = new Parcelable.ClassLoaderCreator<State>()
    {

        @Override
        public State createFromParcel(Parcel source)
        {
            return createFromParcel(source, null);
        }

        @Override
        public State createFromParcel(Parcel source, ClassLoader loader)
        {
            return new State(source, loader);
        }

        @Override
        public State[] newArray(int size)
        {
            return new State[size];
        }
    };

    /**
     * Parcelable State's constructor.
     */
    public State (Parcel in, ClassLoader loader) {
        this.mCode = in.readString();
        this.mName = in.readString();
        this.mEnum = (StateEnum) in.readSerializable();
        this.mChildAbuseResource = (Resource) in.readParcelable(loader);
        this.mBullyingResource = (Resource) in.readParcelable(loader);
        this.mDomesticViolenceResource = (Resource) in.readParcelable(loader);
    }

    public State(Context context, StateEnum stateEnum, VectorMasterDrawable USMap) {
        this.context = context;
        this.mCode = stateEnum.toStringCode();
        this.mName = stateEnum.toStringName();
        this.mEnum = stateEnum;
        this.mPathModel = USMap.getPathModelByName(this.mCode);
        this.mPath = this.mPathModel.getPath();
        this.setRegion();
    }

    public String getCode() {
        return this.mCode;
    }

    public String getName() {
        return this.mName;
    }

    public StateEnum getEnum() {
        return this.mEnum;
    }

    public Path getPath() {
        return this.mPath;
    }

    public PathModel getPathModel() { //TODO: call this
        return this.mPathModel;
    }

    public Region getRegion() {
        return this.mRegion;
    }

    public void setFillColor(String color) {
        this.mPathModel.setFillColor(Color.parseColor(color));
    }

    public void setDefaultFillColor() {
        this.mPathModel.setFillColor(Color.parseColor("#f9f9f9"));
    } //TODO Remove when confirmed unnecessary

    public Boolean checkForTap(int x, int y) {
        return this.mRegion.contains(x, y);
    } //TODO remove when confirmed unnecessary

    private void setRegion() {
        RectF bounds = new RectF();
        this.mPath.computeBounds(bounds, true);
        this.mRegion = new Region();
        this.mRegion.setPath(this.mPath, new Region((int) bounds.left, (int) bounds.top, (int) bounds.right, (int) bounds.bottom));
    }

    //todo: test following
    public void setResources(List<Resource> resourceList) { //todo remove resourceList: contact db | or? can the db pass in resourceList
        this.mChildAbuseResource = resourceList.get(0);
        this.mBullyingResource = resourceList.get(1);
        this.mDomesticViolenceResource = resourceList.get(2); //todo
    }

    //todo remove once db is fully set up and hooked up to real data
    public void setDummyResources(List<Resource> resourceList) {
        this.mChildAbuseResource = resourceList.get(0);
        this.mBullyingResource = resourceList.get(1);
        this.mDomesticViolenceResource = resourceList.get(2); //todo
    }

    public Resource getChildAbuseResources() {
        return this.mChildAbuseResource;
    }

    public Resource getBullyingResources() {
        return this.mBullyingResource;
    }

    public Resource getDomesticViolenceResources() {
        return this.mDomesticViolenceResource;
    }

    public List<Resource> getAllResources() {
        return Arrays.asList(this.mChildAbuseResource, this.mBullyingResource, this.mDomesticViolenceResource);
    }
}
