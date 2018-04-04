package org.humanitypreservationfoundation.pulse.widgets;

/**
 * Created by ETASpare on 3/6/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.R;
import org.humanitypreservationfoundation.pulse.enums.StateEnum;
import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;
import org.humanitypreservationfoundation.pulse.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ExpandableResourceListAdapter implements ExpandableListAdapter {
    public static int ALABAMA;
    public static int ALASKA;
    public static int ARIZONA;
    public static int ARKANSAS;
    public static int CALIFORNIA;
    public static int COLORADO;
    public static int CONNECTICUT;
    public static int DELAWARE;
    public static int FLORIDA;
    public static int GEORGIA;
    public static int HAWAII;
    public static int IDAHO;
    public static int ILLINOIS;
    public static int INDIANA;
    public static int IOWA;
    public static int KANSAS;
    public static int KENTUCKY;
    public static int LOUISIANA;
    public static int MAINE;
    public static int MARYLAND;
    public static int MASSACHUSETTS;
    public static int MICHIGAN;
    public static int MINNESOTA;
    public static int MISSISSIPPI;
    public static int MISSOURI;
    public static int MONTANA;
    public static int NEBRASKA;
    public static int NEVADA;
    public static int NEW_HAMPSHIRE;
    public static int NEW_JERSEY;
    public static int NEW_MEXICO;
    public static int NEW_YORK;
    public static int NORTH_CAROLINA;
    public static int NORTH_DAKOTA;
    public static int OHIO;
    public static int OKLAHOMA;
    public static int OREGON;
    public static int PENNSYLVANIA;
    public static int RHODE_ISLAND;
    public static int SOUTH_CAROLINA;
    public static int SOUTH_DAKOTA;
    public static int TENNESSEE;
    public static int TEXAS;
    public static int UTAH;
    public static int VERMONT;
    public static int VIRGINIA;
    public static int WASHINGTON;
    public static int WEST_VIRGINIA;
    public static int WISCONSIN;
    public static int WYOMING;

    private int mStateCount;
    private TimeZoneEnum mTimeZoneEnum;

    //PST States
    private List<Resource> mAlaskaData;
    private List<Resource> mCaliforniaData;
    private List<Resource> mHawaiiData;
    private List<Resource> mOregonData;
    private List<Resource> mWashingtonData;

    //MT States
    private List<Resource> mArizonaData;
    private List<Resource> mColoradoData;
    private List<Resource> mIdahoData;
    private List<Resource> mMontanaData;
    private List<Resource> mNevadaData;
    private List<Resource> mNewMexicoData;
    private List<Resource> mUtahData;
    private List<Resource> mWyomingData;

    //WNC States
    private List<Resource> mIowaData;
    private List<Resource> mKansasData;
    private List<Resource> mMinnesotaData;
    private List<Resource> mMissouriData;
    private List<Resource> mNebraskaData;
    private List<Resource> mNorthDakotaData;
    private List<Resource> mSouthDakotaData;

    //WSC States
    private List<Resource> mArkansasData;
    private List<Resource> mLouisianaData;
    private List<Resource> mOklahomaData;
    private List<Resource> mTexasData;

    //ENC States
    private List<Resource> mIllinoisData;
    private List<Resource> mIndianaData;
    private List<Resource> mMichiganData;
    private List<Resource> mOhioData;
    private List<Resource> mWisconsinData;

    //EST States
    private List<Resource> mAlabamaData;
    private List<Resource> mKentuckyData;
    private List<Resource> mMississippiData;
    private List<Resource> mTennesseeData;

    //MA States
    private List<Resource> mNewJerseyData;
    private List<Resource> mNewYorkData;
    private List<Resource> mPennsylvaniaData;

    //SA States
    private List<Resource> mDelawareData;
    private List<Resource> mFloridaData;
    private List<Resource> mGeorgiaData;
    private List<Resource> mMarylandData;
    private List<Resource> mNorthCarolinaData;
    private List<Resource> mSouthCarolinaData;
    private List<Resource> mVirginiaData;
    private List<Resource> mWestVirginiaData;

    //NE States
    private List<Resource> mConnecticutData;
    private List<Resource> mMaineData;
    private List<Resource> mMassachusettsData;
    private List<Resource> mNewHampshireData;
    private List<Resource> mRhodeIslandData;
    private List<Resource> mVermontData;

    private Context mContext;

    public ExpandableResourceListAdapter(Context context, int stateCount, TimeZoneEnum timeZoneEnum) {
        this.mContext = context;
        this.mStateCount = stateCount;
        this.mTimeZoneEnum = timeZoneEnum;
        this.setGroupPosition(StateEnum.getTimeZoneStateCodes(this.mTimeZoneEnum));

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.PST) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            //PST States
            this.mAlaskaData = new ArrayList<>();
            this.mCaliforniaData = new ArrayList<>();
            this.mHawaiiData = new ArrayList<>();
            this.mOregonData = new ArrayList<>();
            this.mWashingtonData = new ArrayList<>();
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.MT) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            //MT States
            this.mArizonaData = new ArrayList<>();
            this.mColoradoData = new ArrayList<>();
            this.mIdahoData = new ArrayList<>();
            this.mMontanaData = new ArrayList<>();
            this.mNevadaData = new ArrayList<>();
            this.mNewMexicoData = new ArrayList<>();
            this.mUtahData = new ArrayList<>();
            this.mWyomingData = new ArrayList<>();
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.WNC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            //WNC States
            this.mIowaData = new ArrayList<>();
            this.mKansasData = new ArrayList<>();
            this.mMinnesotaData = new ArrayList<>();
            this.mMissouriData = new ArrayList<>();
            this.mNebraskaData = new ArrayList<>();
            this.mNorthDakotaData = new ArrayList<>();
            this.mSouthDakotaData = new ArrayList<>();
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.WSC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            //WSC States
            this.mArkansasData = new ArrayList<>();
            this.mLouisianaData = new ArrayList<>();
            this.mOklahomaData = new ArrayList<>();
            this.mTexasData = new ArrayList<>();
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.ENC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            //ENC States
            this.mIllinoisData = new ArrayList<>();
            this.mIndianaData = new ArrayList<>();
            this.mMichiganData = new ArrayList<>();
            this.mOhioData = new ArrayList<>();
            this.mWisconsinData = new ArrayList<>();
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.ESC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            //ESC States
            this.mAlabamaData = new ArrayList<>();
            this.mKentuckyData = new ArrayList<>();
            this.mMississippiData = new ArrayList<>();
            this.mTennesseeData = new ArrayList<>();
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.MA) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            //MA States
            this.mNewJerseyData = new ArrayList<>();
            this.mNewYorkData = new ArrayList<>();
            this.mPennsylvaniaData = new ArrayList<>();
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.SA) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            //SA States
            this.mDelawareData = new ArrayList<>();
            this.mFloridaData = new ArrayList<>();
            this.mGeorgiaData = new ArrayList<>();
            this.mMarylandData = new ArrayList<>();
            this.mNorthCarolinaData = new ArrayList<>();
            this.mSouthCarolinaData = new ArrayList<>();
            this.mVirginiaData = new ArrayList<>();
            this.mWestVirginiaData = new ArrayList<>();
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.NE) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            //NE States
            this.mConnecticutData = new ArrayList<>();
            this.mMaineData = new ArrayList<>();
            this.mMassachusettsData = new ArrayList<>();
            this.mNewHampshireData = new ArrayList<>();
            this.mRhodeIslandData = new ArrayList<>();
            this.mVermontData = new ArrayList<>();
        }
    }

    private void setGroupPosition(List<StateEnum> states) {
        int position = 0;
        for (int i = 0; i < states.size(); i++) {
            if (this.mTimeZoneEnum.equals(TimeZoneEnum.PST) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
                if (states.get(i).equals(StateEnum.ALASKA)) {
                    ALASKA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.CALIFORNIA)) {
                    CALIFORNIA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.HAWAII)) {
                    HAWAII = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.OREGON)) {
                    OREGON = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.WASHINGTON)) {
                    WASHINGTON = position;
                    position += 1;
                }
            }

            if (this.mTimeZoneEnum.equals(TimeZoneEnum.MT) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
                if (states.get(i).equals(StateEnum.ARIZONA)) {
                    ARIZONA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.COLORADO)) {
                    COLORADO = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.IDAHO)) {
                    IDAHO = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.MONTANA)) {
                    MONTANA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.NEVADA)) {
                    NEVADA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.NEW_MEXICO)) {
                    NEW_MEXICO = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.UTAH)) {
                    UTAH = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.WYOMING)) {
                    WYOMING = position;
                    position += 1;
                }
            }

            if (this.mTimeZoneEnum.equals(TimeZoneEnum.WNC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
                if (states.get(i).equals(StateEnum.IOWA)) {
                    IOWA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.KANSAS)) {
                    KANSAS = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.MINNESOTA)) {
                    MINNESOTA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.MISSOURI)) {
                    MISSOURI = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.NEBRASKA)) {
                    NEBRASKA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.NORTH_DAKOTA)) {
                    NORTH_DAKOTA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.SOUTH_DAKOTA)) {
                    SOUTH_DAKOTA = position;
                    position += 1;
                }
            }

            if (this.mTimeZoneEnum.equals(TimeZoneEnum.WSC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
                if (states.get(i).equals(StateEnum.ARKANSAS)) {
                    ARKANSAS = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.LOUISIANA)) {
                    LOUISIANA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.OKLAHOMA)) {
                    OKLAHOMA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.TEXAS)) {
                    TEXAS = position;
                    position += 1;
                }
            }

            if (this.mTimeZoneEnum.equals(TimeZoneEnum.ENC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
                if (states.get(i).equals(StateEnum.ILLINOIS)) {
                    ILLINOIS = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.INDIANA)) {
                    INDIANA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.MICHIGAN)) {
                    MICHIGAN = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.OHIO)) {
                    OHIO = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.WISCONSIN)) {
                    WISCONSIN = position;
                    position += 1;
                }
            }

            if (this.mTimeZoneEnum.equals(TimeZoneEnum.ESC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
                if (states.get(i).equals(StateEnum.ALABAMA)) {
                    ALABAMA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.KENTUCKY)) {
                    KENTUCKY = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.MISSISSIPPI)) {
                    MISSISSIPPI = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.TENNESSEE)) {
                    TENNESSEE = position;
                    position += 1;
                }
            }

            if (this.mTimeZoneEnum.equals(TimeZoneEnum.MA) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
                if (states.get(i).equals(StateEnum.NEW_JERSEY)) {
                    NEW_JERSEY = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.NEW_YORK)) {
                    NEW_YORK = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.PENNSYLVANIA)) {
                    PENNSYLVANIA = position;
                    position += 1;
                }
            }

            if (this.mTimeZoneEnum.equals(TimeZoneEnum.SA) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
                if (states.get(i).equals(StateEnum.DELAWARE)) {
                    DELAWARE = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.FLORIDA)) {
                    FLORIDA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.GEORGIA)) {
                    GEORGIA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.MARYLAND)) {
                    MARYLAND = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.NORTH_CAROLINA)) {
                    NORTH_CAROLINA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.SOUTH_CAROLINA)) {
                    SOUTH_CAROLINA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.VIRGINIA)) {
                    VIRGINIA = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.WEST_VIRGINIA)) {
                    WEST_VIRGINIA = position;
                    position += 1;
                }
            }

            if (this.mTimeZoneEnum.equals(TimeZoneEnum.NE) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
                if (states.get(i).equals(StateEnum.CONNECTICUT)) {
                    CONNECTICUT = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.MAINE)) {
                    MAINE = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.MASSACHUSETTS)) {
                    MASSACHUSETTS = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.NEW_HAMPSHIRE)) {
                    NEW_HAMPSHIRE = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.RHODE_ISLAND)) {
                    RHODE_ISLAND = position;
                    position += 1;
                } else if (states.get(i).equals(StateEnum.VERMONT)) {
                    VERMONT = position;
                    position += 1;
                }
            }
        }
    }

    /**
     * Adds Resource results to appropriate list depending on the <code>groupPosition</code>
     * @param groupPosition options: one of the public static ints declared at top of file
     * @param data list of Resources
     */
    //TODO: Call in ResultsActivity adapter.addDataToGroup()
    public void addDataToGroup(int groupPosition, List<? extends Resource> data) {
        if (this.mTimeZoneEnum.equals(TimeZoneEnum.PST) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ALASKA) {
                mAlaskaData.addAll(data);
            } else if (groupPosition == CALIFORNIA) {
                mCaliforniaData.addAll(data);
            } else if (groupPosition == HAWAII) {
                mHawaiiData.addAll(data);
            } else if (groupPosition == OREGON) {
                mOregonData.addAll(data);
            } else if (groupPosition == WASHINGTON) {
                mWashingtonData.addAll(data);
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.MT) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ARIZONA) {
                mArizonaData.addAll(data);
            } else if (groupPosition == COLORADO) {
                mColoradoData.addAll(data);
            } else if (groupPosition == IDAHO) {
                mIdahoData.addAll(data);
            } else if (groupPosition == MONTANA) {
                mMontanaData.addAll(data);
            } else if (groupPosition == NEVADA) {
                mNevadaData.addAll(data);
            } else if (groupPosition == NEW_MEXICO) {
                mNewMexicoData.addAll(data);
            } else if (groupPosition == UTAH) {
                mUtahData.addAll(data);
            } else if (groupPosition == WYOMING) {
                mWyomingData.addAll(data);
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.WNC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == IOWA) {
                mIowaData.addAll(data);
            } else if (groupPosition == KANSAS) {
                mKansasData.addAll(data);
            } else if (groupPosition == MINNESOTA) {
                mMinnesotaData.addAll(data);
            } else if (groupPosition == MISSOURI) {
                mMissouriData.addAll(data);
            } else if (groupPosition == NEBRASKA) {
                mNebraskaData.addAll(data);
            } else if (groupPosition == NORTH_DAKOTA) {
                mNorthDakotaData.addAll(data);
            } else if (groupPosition == SOUTH_DAKOTA) {
                mSouthDakotaData.addAll(data);
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.WSC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ARKANSAS) {
                mArkansasData.addAll(data);
            } else if (groupPosition == LOUISIANA) {
                mLouisianaData.addAll(data);
            } else if (groupPosition == OKLAHOMA) {
                mOklahomaData.addAll(data);
            } else if (groupPosition == TEXAS) {
                mTexasData.addAll(data);
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.ENC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ILLINOIS) {
                mIllinoisData.addAll(data);
            } else if (groupPosition == INDIANA) {
                mIndianaData.addAll(data);
            } else if (groupPosition == MICHIGAN) {
                mMichiganData.addAll(data);
            } else if (groupPosition == OHIO) {
                mOhioData.addAll(data);
            } else if (groupPosition == WISCONSIN) {
                mWisconsinData.addAll(data);
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.ESC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ALABAMA) {
                mAlabamaData.addAll(data);
            } else if (groupPosition == KENTUCKY) {
                mKentuckyData.addAll(data);
            } else if (groupPosition == MISSISSIPPI) {
                mMississippiData.addAll(data);
            } else if (groupPosition == TENNESSEE) {
                mTennesseeData.addAll(data);
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.MA) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == NEW_JERSEY) {
                mNewJerseyData.addAll(data);
            } else if (groupPosition == NEW_YORK) {
                mNewYorkData.addAll(data);
            } else if (groupPosition == PENNSYLVANIA) {
                mPennsylvaniaData.addAll(data);
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.SA) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == DELAWARE) {
                mDelawareData.addAll(data);
            } else if (groupPosition == FLORIDA) {
                mFloridaData.addAll(data);
            } else if (groupPosition == GEORGIA) {
                mGeorgiaData.addAll(data);
            } else if (groupPosition == MARYLAND) {
                mMarylandData.addAll(data);
            } else if (groupPosition == NORTH_CAROLINA) {
                mNorthCarolinaData.addAll(data);
            } else if (groupPosition == SOUTH_CAROLINA) {
                mSouthCarolinaData.addAll(data);
            } else if (groupPosition == VIRGINIA) {
                mVirginiaData.addAll(data);
            } else if (groupPosition == WEST_VIRGINIA) {
                mWestVirginiaData.addAll(data);
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.NE) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == CONNECTICUT) {
                mConnecticutData.addAll(data);
            } else if (groupPosition == MAINE) {
                mMaineData.addAll(data);
            } else if (groupPosition == MASSACHUSETTS) {
                mMassachusettsData.addAll(data);
            } else if (groupPosition == NEW_HAMPSHIRE) {
                mNewHampshireData.addAll(data);
            } else if (groupPosition == RHODE_ISLAND) {
                mRhodeIslandData.addAll(data);
            } else if (groupPosition == VERMONT) {
                mVermontData.addAll(data);
            }
        }
    }

    public boolean areAllItemsEnabled() {
        return true;
    }

    public Object getChild(int groupPosition, int childPosition) {
        if (this.mTimeZoneEnum.equals(TimeZoneEnum.PST) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ALASKA) {
                return mAlaskaData.get(childPosition);
            } else if (groupPosition == CALIFORNIA) {
                return mCaliforniaData.get(childPosition);
            } else if (groupPosition == HAWAII) {
                return mHawaiiData.get(childPosition);
            } else if (groupPosition == OREGON) {
                return mOregonData.get(childPosition);
            } else if (groupPosition == WASHINGTON) {
                return mWashingtonData.get(childPosition);
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.MT) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ARIZONA) {
                return mArizonaData.get(childPosition);
            } else if (groupPosition == COLORADO) {
                return mColoradoData.get(childPosition);
            } else if (groupPosition == IDAHO) {
                return mIdahoData.get(childPosition);
            } else if (groupPosition == MONTANA) {
                return mMontanaData.get(childPosition);
            } else if (groupPosition == NEVADA) {
                return mNevadaData.get(childPosition);
            } else if (groupPosition == NEW_MEXICO) {
                return mNewMexicoData.get(childPosition);
            } else if (groupPosition == UTAH) {
                return mUtahData.get(childPosition);
            } else if (groupPosition == WYOMING) {
                return mWyomingData.get(childPosition);
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.WNC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == IOWA) {
                return mIowaData.get(childPosition);
            } else if (groupPosition == KANSAS) {
                return mKansasData.get(childPosition);
            } else if (groupPosition == MINNESOTA) {
                return mMinnesotaData.get(childPosition);
            } else if (groupPosition == MISSOURI) {
                return mMissouriData.get(childPosition);
            } else if (groupPosition == NEBRASKA) {
                return mNebraskaData.get(childPosition);
            } else if (groupPosition == NORTH_DAKOTA) {
                return mNorthDakotaData.get(childPosition);
            } else if (groupPosition == SOUTH_DAKOTA) {
                return mSouthDakotaData.get(childPosition);
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.WSC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ARKANSAS) {
                return mArkansasData.get(childPosition);
            } else if (groupPosition == LOUISIANA) {
                return mLouisianaData.get(childPosition);
            } else if (groupPosition == OKLAHOMA) {
                return mOklahomaData.get(childPosition);
            } else if (groupPosition == TEXAS) {
                return mTexasData.get(childPosition);
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.ENC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ILLINOIS) {
                return mIllinoisData.get(childPosition);
            } else if (groupPosition == INDIANA) {
                return mIndianaData.get(childPosition);
            } else if (groupPosition == MICHIGAN) {
                return mMichiganData.get(childPosition);
            } else if (groupPosition == OHIO) {
                return mOhioData.get(childPosition);
            } else if (groupPosition == WISCONSIN) {
                return mWisconsinData.get(childPosition);
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.ESC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ALABAMA) {
                return mAlabamaData.get(childPosition);
            } else if (groupPosition == KENTUCKY) {
                return mKentuckyData.get(childPosition);
            } else if (groupPosition == MISSISSIPPI) {
                return mMississippiData.get(childPosition);
            } else if (groupPosition == TENNESSEE) {
                return mTennesseeData.get(childPosition);
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.MA) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == NEW_JERSEY) {
                return mNewJerseyData.get(childPosition);
            } else if (groupPosition == NEW_YORK) {
                return mNewYorkData.get(childPosition);
            } else if (groupPosition == PENNSYLVANIA) {
                return mPennsylvaniaData.get(childPosition);
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.SA) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == DELAWARE) {
                return mDelawareData.get(childPosition);
            } else if (groupPosition == FLORIDA) {
                return mFloridaData.get(childPosition);
            } else if (groupPosition == GEORGIA) {
                return mGeorgiaData.get(childPosition);
            } else if (groupPosition == MARYLAND) {
                return mMarylandData.get(childPosition);
            } else if (groupPosition == NORTH_CAROLINA) {
                return mNorthCarolinaData.get(childPosition);
            } else if (groupPosition == SOUTH_CAROLINA) {
                return mSouthCarolinaData.get(childPosition);
            } else if (groupPosition == VIRGINIA) {
                return mVirginiaData.get(childPosition);
            } else if (groupPosition == WEST_VIRGINIA) {
                return mWestVirginiaData.get(childPosition);
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.NE) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == CONNECTICUT) {
                return mConnecticutData.get(childPosition);
            } else if (groupPosition == MAINE) {
                return mMaineData.get(childPosition);
            } else if (groupPosition == MASSACHUSETTS) {
                return mMassachusettsData.get(childPosition);
            } else if (groupPosition == NEW_HAMPSHIRE) {
                return mNewHampshireData.get(childPosition);
            } else if (groupPosition == RHODE_ISLAND) {
                return mRhodeIslandData.get(childPosition);
            } else if (groupPosition == VERMONT) {
                return mVermontData.get(childPosition);
            }
        }
        return null;
    }

    /**
     * Returns a resources's Id
     */
    public long getChildId(int groupPosition, int childPosition) {
        Resource resource = (Resource) getChild(groupPosition, childPosition);
        if (resource != null) {
            return resource.getId();
        }

        return -childPosition; //todo: look into: is this what it should be returning?
    }

    /**
     * Depending on the <code>groupPosition</code>, returns the size of the appropriate data group
     * @return size of data group
     */
    public int getChildrenCount(int groupPosition) {
        if (this.mTimeZoneEnum.equals(TimeZoneEnum.PST) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ALASKA) {
                return mAlaskaData.size();
            } else if (groupPosition == CALIFORNIA) {
                return mCaliforniaData.size();
            } else if (groupPosition == HAWAII) {
                return mHawaiiData.size();
            } else if (groupPosition == OREGON) {
                return mOregonData.size();
            } else if (groupPosition == WASHINGTON) {
                return mWashingtonData.size();
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.MT) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ARIZONA) {
                return mArizonaData.size();
            } else if (groupPosition == COLORADO) {
                return mColoradoData.size();
            } else if (groupPosition == IDAHO) {
                return mIdahoData.size();
            } else if (groupPosition == MONTANA) {
                return mMontanaData.size();
            } else if (groupPosition == NEVADA) {
                return mNevadaData.size();
            } else if (groupPosition == NEW_MEXICO) {
                return mNewMexicoData.size();
            } else if (groupPosition == UTAH) {
                return mUtahData.size();
            } else if (groupPosition == WYOMING) {
                return mWyomingData.size();
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.WNC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == IOWA) {
                return mIowaData.size();
            } else if (groupPosition == KANSAS) {
                return mKansasData.size();
            } else if (groupPosition == MINNESOTA) {
                return mMinnesotaData.size();
            } else if (groupPosition == MISSOURI) {
                return mMissouriData.size();
            } else if (groupPosition == NEBRASKA) {
                return mNebraskaData.size();
            } else if (groupPosition == NORTH_DAKOTA) {
                return mNorthDakotaData.size();
            } else if (groupPosition == SOUTH_DAKOTA) {
                return mSouthDakotaData.size();
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.WSC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ARKANSAS) {
                return mArkansasData.size();
            } else if (groupPosition == LOUISIANA) {
                return mLouisianaData.size();
            } else if (groupPosition == OKLAHOMA) {
                return mOklahomaData.size();
            } else if (groupPosition == TEXAS) {
                return mTexasData.size();
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.ENC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ILLINOIS) {
                return mIllinoisData.size();
            } else if (groupPosition == INDIANA) {
                return mIndianaData.size();
            } else if (groupPosition == MICHIGAN) {
                return mMichiganData.size();
            } else if (groupPosition == OHIO) {
                return mOhioData.size();
            } else if (groupPosition == WISCONSIN) {
                return mWisconsinData.size();
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.ESC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ALABAMA) {
                return mAlabamaData.size();
            } else if (groupPosition == KENTUCKY) {
                return mKentuckyData.size();
            } else if (groupPosition == MISSISSIPPI) {
                return mMississippiData.size();
            } else if (groupPosition == TENNESSEE) {
                return mTennesseeData.size();
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.MA) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == NEW_JERSEY) {
                return mNewJerseyData.size();
            } else if (groupPosition == NEW_YORK) {
                return mNewYorkData.size();
            } else if (groupPosition == PENNSYLVANIA) {
                return mPennsylvaniaData.size();
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.SA) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == DELAWARE) {
                return mDelawareData.size();
            } else if (groupPosition == FLORIDA) {
                return mFloridaData.size();
            } else if (groupPosition == GEORGIA) {
                return mGeorgiaData.size();
            } else if (groupPosition == MARYLAND) {
                return mMarylandData.size();
            } else if (groupPosition == NORTH_CAROLINA) {
                return mNorthCarolinaData.size();
            } else if (groupPosition == SOUTH_CAROLINA) {
                return mSouthCarolinaData.size();
            } else if (groupPosition == VIRGINIA) {
                return mVirginiaData.size();
            } else if (groupPosition == WEST_VIRGINIA) {
                return mWestVirginiaData.size();
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.NE) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == CONNECTICUT) {
                return mConnecticutData.size();
            } else if (groupPosition == MAINE) {
                return mMaineData.size();
            } else if (groupPosition == MASSACHUSETTS) {
                return mMassachusettsData.size();
            } else if (groupPosition == NEW_HAMPSHIRE) {
                return mNewHampshireData.size();
            } else if (groupPosition == RHODE_ISLAND) {
                return mRhodeIslandData.size();
            } else if (groupPosition == VERMONT) {
                return mVermontData.size();
            }
        }
        return 0;
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.resource_list_item, parent, false);

        final Resource resource = (Resource) getChild(groupPosition, childPosition);

        if (resource != null) {
            TextView orgName = (TextView) view.findViewById(R.id.txt_org_name);
            TextView orgState = (TextView) view.findViewById(R.id.txt_org_subtitle);
            Button orgWeb = (Button) view.findViewById(R.id.btn_org_web);
            Button orgCall = (Button) view.findViewById(R.id.btn_org_call);

            orgName.setText(resource.getName());
            orgState.setText(resource.getCategory());

            orgWeb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openWebsite(resource.getUrl());
                }
            });

            orgCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    call(resource.getPhoneNumber());
                }
            });
        }

        //Adds 8dp padding to top of view if it's the first view
        if (childPosition == 0) {
            view.setPadding(0,(int) Utils.dpToPx(this.mContext, 8),0, 0);
        }

        //Adds 16dp padding to bottom of view if it's that last view
        if (childPosition == 2) {
            view.setPadding(0,0,0, (int) Utils.dpToPx(this.mContext, 16));
        }
        return view;
    }

    /**
     * Called when Website is clicked. Opens Website in user's browser
     */
    private void openWebsite(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        this.mContext.startActivity(intent);
    }

    /**
     * Called when Call is clicked. Opens user's phone client with phoneNumber populated
     */
    private void call(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        this.mContext.startActivity(intent);
    }

    public long getCombinedChildId(long groupId, long childId) {
        return 0L;
    }

    public long getCombinedGroupId(long groupId) {
        return groupId;
    }

    /**
     * Depending on <code>groupPosition</code>, returns appropriate group's data
     */
    public Object getGroup(int groupPosition) {
        if (this.mTimeZoneEnum.equals(TimeZoneEnum.PST) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ALASKA) {
                return mAlaskaData;
            } else if (groupPosition == CALIFORNIA) {
                return mCaliforniaData;
            } else if (groupPosition == HAWAII) {
                return mHawaiiData;
            } else if (groupPosition == OREGON) {
                return mOregonData;
            } else if (groupPosition == WASHINGTON) {
                return mWashingtonData;
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.MT) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ARIZONA) {
                return mArizonaData;
            } else if (groupPosition == COLORADO) {
                return mColoradoData;
            } else if (groupPosition == IDAHO) {
                return mIdahoData;
            } else if (groupPosition == MONTANA) {
                return mMontanaData;
            } else if (groupPosition == NEVADA) {
                return mNevadaData;
            } else if (groupPosition == NEW_MEXICO) {
                return mNewMexicoData;
            } else if (groupPosition == UTAH) {
                return mUtahData;
            } else if (groupPosition == WYOMING) {
                return mWyomingData;
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.WNC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == IOWA) {
                return mIowaData;
            } else if (groupPosition == KANSAS) {
                return mKansasData;
            } else if (groupPosition == MINNESOTA) {
                return mMinnesotaData;
            } else if (groupPosition == MISSOURI) {
                return mMissouriData;
            } else if (groupPosition == NEBRASKA) {
                return mNebraskaData;
            } else if (groupPosition == NORTH_DAKOTA) {
                return mNorthDakotaData;
            } else if (groupPosition == SOUTH_DAKOTA) {
                return mSouthDakotaData;
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.WSC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ARKANSAS) {
                return mArkansasData;
            } else if (groupPosition == LOUISIANA) {
                return mLouisianaData;
            } else if (groupPosition == OKLAHOMA) {
                return mOklahomaData;
            } else if (groupPosition == TEXAS) {
                return mTexasData;
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.ENC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ILLINOIS) {
                return mIllinoisData;
            } else if (groupPosition == INDIANA) {
                return mIndianaData;
            } else if (groupPosition == MICHIGAN) {
                return mMichiganData;
            } else if (groupPosition == OHIO) {
                return mOhioData;
            } else if (groupPosition == WISCONSIN) {
                return mWisconsinData;
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.ESC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ALABAMA) {
                return mAlabamaData;
            } else if (groupPosition == KENTUCKY) {
                return mKentuckyData;
            } else if (groupPosition == MISSISSIPPI) {
                return mMississippiData;
            } else if (groupPosition == TENNESSEE) {
                return mTennesseeData;
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.MA) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == NEW_JERSEY) {
                return mNewJerseyData;
            } else if (groupPosition == NEW_YORK) {
                return mNewYorkData;
            } else if (groupPosition == PENNSYLVANIA) {
                return mPennsylvaniaData;
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.SA) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == DELAWARE) {
                return mDelawareData;
            } else if (groupPosition == FLORIDA) {
                return mFloridaData;
            } else if (groupPosition == GEORGIA) {
                return mGeorgiaData;
            } else if (groupPosition == MARYLAND) {
                return mMarylandData;
            } else if (groupPosition == NORTH_CAROLINA) {
                return mNorthCarolinaData;
            } else if (groupPosition == SOUTH_CAROLINA) {
                return mSouthCarolinaData;
            } else if (groupPosition == VIRGINIA) {
                return mVirginiaData;
            } else if (groupPosition == WEST_VIRGINIA) {
                return mWestVirginiaData;
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.NE) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == CONNECTICUT) {
                return mConnecticutData;
            } else if (groupPosition == MAINE) {
                return mMaineData;
            } else if (groupPosition == MASSACHUSETTS) {
                return mMassachusettsData;
            } else if (groupPosition == NEW_HAMPSHIRE) {
                return mNewHampshireData;
            } else if (groupPosition == RHODE_ISLAND) {
                return mRhodeIslandData;
            } else if (groupPosition == VERMONT) {
                return mVermontData;
            }
        }

        return null;
    }

    /**
     * Returns the number of groups in <code>ExpandableListView</code>
     */
    public int getGroupCount() {
        return this.mStateCount;
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * Inflates <code>R.layout.list_header</code>, set's <code>title</code>, and set's each group
     * header with the string associated with <code>title</code>.
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.resource_list_header, null, false);

        String title = "";
        if (this.mTimeZoneEnum.equals(TimeZoneEnum.PST) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ALASKA) {
                title = StateEnum.ALASKA.toStringName();
            } else if (groupPosition == CALIFORNIA) {
                title = StateEnum.CALIFORNIA.toStringName();
            } else if (groupPosition == HAWAII) {
                title = StateEnum.HAWAII.toStringName();
            } else if (groupPosition == OREGON) {
                title = StateEnum.OREGON.toStringName();
            } else if (groupPosition == WASHINGTON) {
                title = StateEnum.WASHINGTON.toStringName();
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.MT) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ARIZONA) {
                title = StateEnum.ARIZONA.toStringName();
            } else if (groupPosition == COLORADO) {
                title = StateEnum.COLORADO.toStringName();
            } else if (groupPosition == IDAHO) {
                title = StateEnum.IDAHO.toStringName();
            } else if (groupPosition == MONTANA) {
                title = StateEnum.MONTANA.toStringName();
            } else if (groupPosition == NEVADA) {
                title = StateEnum.NEVADA.toStringName();
            } else if (groupPosition == NEW_MEXICO) {
                title = StateEnum.NEW_MEXICO.toStringName();
            } else if (groupPosition == UTAH) {
                title = StateEnum.UTAH.toStringName();
            } else if (groupPosition == WYOMING) {
                title = StateEnum.WYOMING.toStringName();
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.WNC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == IOWA) {
                title = StateEnum.IOWA.toStringName();
            } else if (groupPosition == KANSAS) {
                title = StateEnum.KANSAS.toStringName();
            } else if (groupPosition == MINNESOTA) {
                title = StateEnum.MINNESOTA.toStringName();
            } else if (groupPosition == MISSOURI) {
                title = StateEnum.MISSOURI.toStringName();
            } else if (groupPosition == NEBRASKA) {
                title = StateEnum.NEBRASKA.toStringName();
            } else if (groupPosition == NORTH_DAKOTA) {
                title = StateEnum.NORTH_DAKOTA.toStringName();
            } else if (groupPosition == SOUTH_DAKOTA) {
                title = StateEnum.SOUTH_DAKOTA.toStringName();
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.WSC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ARKANSAS) {
                title = StateEnum.ARKANSAS.toStringName();
            } else if (groupPosition == LOUISIANA) {
                title = StateEnum.LOUISIANA.toStringName();
            } else if (groupPosition == OKLAHOMA) {
                title = StateEnum.OKLAHOMA.toStringName();
            } else if (groupPosition == TEXAS) {
                title = StateEnum.TEXAS.toStringName();
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.ENC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ILLINOIS) {
                title = StateEnum.ILLINOIS.toStringName();
            } else if (groupPosition == INDIANA) {
                title = StateEnum.INDIANA.toStringName();
            } else if (groupPosition == MICHIGAN) {
                title = StateEnum.MICHIGAN.toStringName();
            } else if (groupPosition == OHIO) {
                title = StateEnum.OHIO.toStringName();
            } else if (groupPosition == WISCONSIN) {
                title = StateEnum.WISCONSIN.toStringName();
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.ESC) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == ALABAMA) {
                title = StateEnum.ALABAMA.toStringName();
            } else if (groupPosition == KENTUCKY) {
                title = StateEnum.KENTUCKY.toStringName();
            } else if (groupPosition == MISSISSIPPI) {
                title = StateEnum.MISSISSIPPI.toStringName();
            } else if (groupPosition == TENNESSEE) {
                title = StateEnum.TENNESSEE.toStringName();
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.MA) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == NEW_JERSEY) {
                title = StateEnum.NEW_JERSEY.toStringName();
            } else if (groupPosition == NEW_YORK) {
                title = StateEnum.NEW_YORK.toStringName();
            } else if (groupPosition == PENNSYLVANIA) {
                title = StateEnum.PENNSYLVANIA.toStringName();
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.SA) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == DELAWARE) {
                title = StateEnum.DELAWARE.toStringName();
            } else if (groupPosition == FLORIDA) {
                title = StateEnum.FLORIDA.toStringName();
            } else if (groupPosition == GEORGIA) {
                title = StateEnum.GEORGIA.toStringName();
            } else if (groupPosition == MARYLAND) {
                title = StateEnum.MARYLAND.toStringName();
            } else if (groupPosition == NORTH_CAROLINA) {
                title = StateEnum.NORTH_CAROLINA.toStringName();
            } else if (groupPosition == SOUTH_CAROLINA) {
                title = StateEnum.SOUTH_CAROLINA.toStringName();
            } else if (groupPosition == VIRGINIA) {
                title = StateEnum.VIRGINIA.toStringName();
            } else if (groupPosition == WEST_VIRGINIA) {
                title = StateEnum.WEST_VIRGINIA.toStringName();
            }
        }

        if (this.mTimeZoneEnum.equals(TimeZoneEnum.NE) || this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            if (groupPosition == CONNECTICUT) {
                title = StateEnum.CONNECTICUT.toStringName();
            } else if (groupPosition == MAINE) {
                title = StateEnum.MAINE.toStringName();
            } else if (groupPosition == MASSACHUSETTS) {
                title = StateEnum.MASSACHUSETTS.toStringName();
            } else if (groupPosition == NEW_HAMPSHIRE) {
                title = StateEnum.NEW_HAMPSHIRE.toStringName();
            } else if (groupPosition == RHODE_ISLAND) {
                title = StateEnum.RHODE_ISLAND.toStringName();
            } else if (groupPosition == VERMONT) {
                title = StateEnum.VERMONT.toStringName();
            }
        }

        ((TextView) view.findViewById(R.id.header)).setText(title);

        return view;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public boolean isEmpty() {
        if (this.mTimeZoneEnum.equals(TimeZoneEnum.ALL)) {
            return mAlaskaData.size() == 0 && mCaliforniaData.size() == 0
                    && mHawaiiData.size() == 0 && mOregonData.size() == 0
                    && mWashingtonData.size() == 0 && mArizonaData.size() == 0
                    && mColoradoData.size() == 0 && mIdahoData.size() == 0
                    && mMontanaData.size() == 0 && mNevadaData.size() == 0
                    && mNewMexicoData.size() == 0 && mUtahData.size() == 0
                    && mWyomingData.size() == 0 && mIowaData.size() == 0
                    && mKansasData.size() == 0 && mMinnesotaData.size() == 0
                    && mMissouriData.size() == 0 && mNebraskaData.size() == 0
                    && mNorthDakotaData.size() == 0 && mSouthDakotaData.size() == 0
                    && mArkansasData.size() == 0 && mLouisianaData.size() == 0
                    && mOklahomaData.size() == 0 && mTexasData.size() == 0
                    && mIllinoisData.size() == 0 && mIndianaData.size() == 0
                    && mMichiganData.size() == 0 && mOhioData.size() == 0
                    && mWisconsinData.size() == 0 && mAlabamaData.size() == 0
                    && mKentuckyData.size() == 0 && mMississippiData.size() == 0
                    && mTennesseeData.size() == 0 && mNewJerseyData.size() == 0
                    && mNewYorkData.size() == 0 && mPennsylvaniaData.size() == 0
                    && mDelawareData.size() == 0 && mFloridaData.size() == 0
                    && mGeorgiaData.size() == 0 && mMarylandData.size() == 0
                    && mNorthCarolinaData.size() == 0 && mSouthCarolinaData.size() == 0
                    && mVirginiaData.size() == 0 && mWestVirginiaData.size() == 0
                    && mConnecticutData.size() == 0 && mMaineData.size() == 0
                    && mMassachusettsData.size() == 0 && mNewHampshireData.size() == 0
                    && mRhodeIslandData.size() == 0 && mVermontData.size() == 0;
        } else if (this.mTimeZoneEnum.equals(TimeZoneEnum.PST)) {
            return mAlaskaData.size() == 0 && mCaliforniaData.size() == 0
                    && mHawaiiData.size() == 0 && mOregonData.size() == 0
                    && mWashingtonData.size() == 0;
        }  else if (this.mTimeZoneEnum.equals(TimeZoneEnum.MT)) {
            return mArizonaData.size() == 0
                    && mColoradoData.size() == 0 && mIdahoData.size() == 0
                    && mMontanaData.size() == 0 && mNevadaData.size() == 0
                    && mNewMexicoData.size() == 0 && mUtahData.size() == 0
                    && mWyomingData.size() == 0;
        }  else if (this.mTimeZoneEnum.equals(TimeZoneEnum.WNC)) {
            return mIowaData.size() == 0
                    && mKansasData.size() == 0 && mMinnesotaData.size() == 0
                    && mMissouriData.size() == 0 && mNebraskaData.size() == 0
                    && mNorthDakotaData.size() == 0 && mSouthDakotaData.size() == 0;
        }  else if (this.mTimeZoneEnum.equals(TimeZoneEnum.WSC)) {
            return mArkansasData.size() == 0 && mLouisianaData.size() == 0
                    && mOklahomaData.size() == 0 && mTexasData.size() == 0;
        }  else if (this.mTimeZoneEnum.equals(TimeZoneEnum.ENC)) {
            return mIllinoisData.size() == 0 && mIndianaData.size() == 0
                    && mMichiganData.size() == 0 && mOhioData.size() == 0
                    && mWisconsinData.size() == 0;
        }  else if (this.mTimeZoneEnum.equals(TimeZoneEnum.ESC)) {
            return mAlabamaData.size() == 0
                    && mKentuckyData.size() == 0 && mMississippiData.size() == 0
                    && mTennesseeData.size() == 0;
        }  else if (this.mTimeZoneEnum.equals(TimeZoneEnum.MA)) {
            return mNewJerseyData.size() == 0
                    && mNewYorkData.size() == 0 && mPennsylvaniaData.size() == 0;
        }  else if (this.mTimeZoneEnum.equals(TimeZoneEnum.SA)) {
            return mDelawareData.size() == 0 && mFloridaData.size() == 0
                    && mGeorgiaData.size() == 0 && mMarylandData.size() == 0
                    && mNorthCarolinaData.size() == 0 && mSouthCarolinaData.size() == 0
                    && mVirginiaData.size() == 0 && mWestVirginiaData.size() == 0;
        }  else if (this.mTimeZoneEnum.equals(TimeZoneEnum.NE)) {
            return mConnecticutData.size() == 0 && mMaineData.size() == 0
                    && mMassachusettsData.size() == 0 && mNewHampshireData.size() == 0
                    && mRhodeIslandData.size() == 0 && mVermontData.size() == 0;
        } else {
            return true;
        }
    }

    public void onGroupCollapsed(int groupPosition) {
        // NA
    }

    public void onGroupExpanded(int groupPosition) {
        // NA
    }

    public void registerDataSetObserver(DataSetObserver observer) {
        // NA
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
        // NA
    }
}
