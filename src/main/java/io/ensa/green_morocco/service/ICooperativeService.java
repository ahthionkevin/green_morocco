package io.ensa.green_morocco.service;

import io.ensa.green_morocco.DTo.Request.CooperativeRequestDTo;
import io.ensa.green_morocco.DTo.Response.CooperativeResponseDTo;
import io.ensa.green_morocco.entity.Cooperative;

import java.util.List;

public interface ICooperativeService {
    CooperativeResponseDTo addCooperative(CooperativeRequestDTo cooperativeRequestDTo);
    List<CooperativeResponseDTo> getCooperatives();
    CooperativeResponseDTo getCooperativeById(Long cooperativeId);
    Cooperative getCooperative(Long cooperativeId);
    CooperativeResponseDTo deleteCooperative(Long cooperativeId);
    CooperativeResponseDTo editCooperative(Long cooperativeId, CooperativeRequestDTo cooperativeRequestDTo);
}
