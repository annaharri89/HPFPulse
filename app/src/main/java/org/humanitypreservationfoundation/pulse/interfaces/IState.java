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
package org.humanitypreservationfoundation.pulse.interfaces;

import android.graphics.Path;
import android.graphics.Region;

import com.sdsmdg.harjot.vectormaster.models.PathModel;

import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.enums.StateEnum;

import java.util.List;

/**
 * Created by ETASpare on 1/23/2018.
 */

public interface IState {
    String getCode();
    String getName();
    StateEnum getEnum();
    Path getPath();
    PathModel getPathModel();
    void setFillColor(String color);
    void setResources(List<Resource> resourceList);
    List<Resource> getChildAbuseResources();
    List<Resource> getBullyingResources();
    List<Resource> getDomesticViolenceResources();
    List<Resource> getAllResources();
}
