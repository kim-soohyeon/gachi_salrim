package com.inhatc.gachi_salrim;


public class Area {
    String cmpnmNm; // 사용처이름
    String refineLotnoAddr; // 건물명주소
    String refineRoadnmAddr; // 도로며웆소
    Double refineWgs84Logt; // 위도
    Double refineWgs84Lat; // 경도
    String sigunNm; // 소속지역

    public Area(){}

    public String getCmpnmNm() {
        return cmpnmNm;
    }

    public void setCmpnmNm(String cmpnmNm) {
        this.cmpnmNm = cmpnmNm;
    }

    public String getRefineLotnoAddr() {
        return refineLotnoAddr;
    }

    public void setRefineLotnoAddr(String refineLotnoAddr) {
        this.refineLotnoAddr = refineLotnoAddr;
    }

    public String getRefineRoadnmAddr() {
        return refineRoadnmAddr;
    }

    public void setRefineRoadnmAddr(String refineRoadnmAddr) {
        this.refineRoadnmAddr = refineRoadnmAddr;
    }

    public Double getRefineWgs84Logt() {
        return refineWgs84Logt;
    }

    public void setRefineWgs84Logt(Double refineWgs84Logt) {
        this.refineWgs84Logt = refineWgs84Logt;
    }

    public Double getRefineWgs84Lat() {
        return refineWgs84Lat;
    }

    public void setRefineWgs84Lat(Double refineWgs84Lat) {
        this.refineWgs84Lat = refineWgs84Lat;
    }

    public String getSigunNm() {
        return sigunNm;
    }

    public void setSigunNm(String sigunNm) {
        this.sigunNm = sigunNm;
    }
}
