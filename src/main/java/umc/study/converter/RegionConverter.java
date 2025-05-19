package umc.study.converter;

import umc.study.domain.Region;

import java.util.ArrayList;

public class RegionConverter {

    public static Region toRegion(String regionName){

        return Region.builder()
                .name(regionName)
                .storeList(new ArrayList<>())
                .build();
    }
}
