package com.sjy.mmkv;

import android.os.Parcel;
import android.os.Parcelable;

public class TestParcelable implements Parcelable {
    public int iValue;
    public String sValue;

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(iValue);
        parcel.writeString(sValue);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public TestParcelable(int i, String s) {
        iValue = i;
        sValue = s;
    }

    private TestParcelable(Parcel in) {
        iValue = in.readInt();
        sValue = in.readString();
    }

    public static final Creator<TestParcelable> CREATOR = new Creator<TestParcelable>() {
        @Override
        public TestParcelable createFromParcel(Parcel parcel) {
            return new TestParcelable(parcel);
        }

        @Override
        public TestParcelable[] newArray(int i) {
            return new TestParcelable[i];
        }
    };
}
