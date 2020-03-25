package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if(versionHistoryMap.containsKey(rollbackVersion)){
            if(rollbackVersion<currentVersion){
                currentVersion = rollbackVersion;
               Iterator<Map.Entry<Integer,String>> iterator = versionHistoryMap.entrySet().iterator();
               while(iterator.hasNext()){
                   Map.Entry<Integer,String>pair = iterator.next();
                  int i = pair.getKey();
                  if(i>currentVersion){
                      iterator.remove();
                  }
                }
                return true;
            }
            else {
                return false;
            }

        }
        else{
            return false;
        }
    }
}
