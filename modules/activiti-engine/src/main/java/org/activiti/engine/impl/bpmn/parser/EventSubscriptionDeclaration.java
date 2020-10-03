/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.engine.impl.bpmn.parser;

import java.io.Serializable;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.impl.persistence.entity.EventSubscriptionEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.MessageEventSubscriptionEntity;
import org.activiti.engine.impl.persistence.entity.SignalEventSubscriptionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;


/**
 * @author Daniel Meyer
 */
public class EventSubscriptionDeclaration implements Serializable {

  protected final String eventName;
  protected final String eventType;
  
  protected boolean async;
  protected String activityId;
  protected boolean isStartEvent;

  public EventSubscriptionDeclaration(String eventName, String eventType) {
    this.eventName = eventName;
    this.eventType = eventType;   
  }
    
  public String getEventName() {
    return eventName;
  }
    
  public boolean isAsync() {
    return async;
  }
  
  public void setAsync(boolean async) {
    this.async = async;
  }
  
  public void setActivityId(String activityId) {
    this.activityId = activityId;   
  }
    
  public String getActivityId() {
    return activityId;
  }
  
  public boolean isStartEvent() {
    return isStartEvent;
  }
  
  public void setStartEvent(boolean isStartEvent) {
    this.isStartEvent = isStartEvent;
  }
  
  public String getEventType() {
    return eventType;
  }

  public EventSubscriptionEntity prepareEventSubscriptionEntity(ExecutionEntity execution) {
    EventSubscriptionEntity eventSubscriptionEntity = null;
    if(eventType.equals("message")) {
      eventSubscriptionEntity = new MessageEventSubscriptionEntity(execution);
    }else  if(eventType.equals("signal")) {
      eventSubscriptionEntity = new SignalEventSubscriptionEntity(execution);
    }else {
      throw new ActivitiException("Found event definition of unknown type: "+eventType);
    }
    
    eventSubscriptionEntity.setEventName(eventName);
    if(activityId != null) {
      ActivityImpl activity = execution.getActivity().findActivity(activityId);
      eventSubscriptionEntity.setActivity(activity);
    }
    return eventSubscriptionEntity;
  }

}
