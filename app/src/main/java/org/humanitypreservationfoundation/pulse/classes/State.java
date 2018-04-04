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

import org.humanitypreservationfoundation.pulse.Config;
import org.humanitypreservationfoundation.pulse.enums.StateEnum;
import org.humanitypreservationfoundation.pulse.interfaces.IState;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ETASpare on 1/23/2018.
 */

public class State implements IState, Parcelable {

    private String mCode;
    private String mName;
    private StateEnum mEnum;
    private Path mPath;
    private PathModel mPathModel;
    private Region mRegion;

    private List<Resource> mChildAbuseResource = new ArrayList<Resource>();
    private List<Resource> mBullyingResource = new ArrayList<Resource>();
    private List<Resource> mDomesticViolenceResource = new ArrayList<Resource>();

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
        dest.writeList(this.mChildAbuseResource);
        dest.writeList(this.mBullyingResource);
        dest.writeList(this.mDomesticViolenceResource);
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
        this.mChildAbuseResource = (List<Resource>) in.readArrayList(loader);
        this.mBullyingResource = (List<Resource>) in.readArrayList(loader);
        this.mDomesticViolenceResource = (List<Resource>) in.readArrayList(loader);
    }

    public State(Context context, StateEnum stateEnum, VectorMasterDrawable USMap) {
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

    private void setRegion() {
        RectF bounds = new RectF();
        this.mPath.computeBounds(bounds, true);
        this.mRegion = new Region();
        this.mRegion.setPath(this.mPath, new Region((int) bounds.left, (int) bounds.top, (int) bounds.right, (int) bounds.bottom));
    }

    public void setResources(List<Resource> resourceList) {
        for (Resource resource : resourceList) {
            switch (resource.getCategory()) {
                case Config.categories.CHILD_ABUSE:
                    this.mChildAbuseResource.add(resource);
                    break;
                case Config.categories.BULLYING:
                    this.mBullyingResource.add(resource);
                    break;
                case Config.categories.DOMESTIC_VIOLENCE:
                    this.mDomesticViolenceResource.add(resource);
                    break;
            }
        }
    }

    public List<Resource> getChildAbuseResources() {
        return this.mChildAbuseResource;
    }

    public List<Resource> getBullyingResources() {
        return this.mBullyingResource;
    }

    public List<Resource> getDomesticViolenceResources() {
        return this.mDomesticViolenceResource;
    }

    public List<Resource> getAllResources() {
        List<Resource> resources = new ArrayList<>();
        resources.addAll(this.mChildAbuseResource);
        resources.addAll(this.mBullyingResource);
        resources.addAll(this.mDomesticViolenceResource);
        return resources;
    }
}
