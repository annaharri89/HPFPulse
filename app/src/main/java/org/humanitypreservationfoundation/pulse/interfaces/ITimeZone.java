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

import org.humanitypreservationfoundation.pulse.classes.Resource;
import org.humanitypreservationfoundation.pulse.classes.State;
import org.humanitypreservationfoundation.pulse.enums.StateEnum;
import org.humanitypreservationfoundation.pulse.enums.TimeZoneEnum;

import java.util.List;
import java.util.Map;

/**
 * Created by ETASpare on 1/27/2018.
 */

public interface ITimeZone {
    List<State> getStates();
    String getName();
    String getCode();
    String getColorCode();
    TimeZoneEnum getEnum();
    String getDescription();
    void changeFillColor(String qualifier);
    void setResources(Map<StateEnum, List<Resource>> resourceMap);
    List<Resource> getStateChildAbuseResources(String stateCode);
    List<Resource> getStateBullyingResources(String stateCode);
    List<Resource> getStateDomesticViolenceResources(String stateCode);
    List<Resource> getAllStateResources(String stateCode);
}
