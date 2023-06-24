package com.geekster.URLHitCounter.Service;

import com.geekster.URLHitCounter.HitCountData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UrlHitService {
    private int hitCount = 0;
    private List<HitCountData> hitCountDataList = new ArrayList<>();

    public synchronized int getHitCount() {
        hitCount++;
        return hitCount;
    }

    public synchronized int getUserHitCount(String username) {
        HitCountData userHitCountData = findUserHitCountData(username);
        if (userHitCountData != null) {
            userHitCountData.incrementHitCount();
        } else {
            userHitCountData = new HitCountData(username);
            hitCountDataList.add(userHitCountData);
        }
        return userHitCountData.getHitCount();
    }

    private HitCountData findUserHitCountData(String username) {
        for (HitCountData data : hitCountDataList) {
            if (data.getUsername().equals(username)) {
                return data;
            }
        }
        return null;
    }
}
