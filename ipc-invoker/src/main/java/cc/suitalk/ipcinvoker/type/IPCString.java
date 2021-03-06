/*
 *  Copyright (C) 2017-present Albie Liang. All rights reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package cc.suitalk.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by albieliang on 2017/6/26.
 */

public class IPCString implements Parcelable {

    public String value;

    public IPCString() {

    }

    public IPCString(String value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(value);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof IPCString) {
            IPCString o = (IPCString) obj;
            return value == o.value || value != null && value.equals(o.value);
        }
        if (obj instanceof String) {
            return obj.equals(value);
        }
        return false;
    }

    public static final Creator<IPCString> CREATOR = new Creator<IPCString>() {
        @Override
        public IPCString createFromParcel(Parcel in) {
            IPCString o = new IPCString();
            o.value = in.readString();
            return o;
        }

        @Override
        public IPCString[] newArray(int size) {
            return new IPCString[size];
        }
    };
}
