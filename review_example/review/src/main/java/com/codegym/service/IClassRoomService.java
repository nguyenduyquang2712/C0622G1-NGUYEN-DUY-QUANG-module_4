package com.codegym.service;

import com.codegym.model.ClassRoom;

import java.util.List;

public interface IClassRoomService {
    List<ClassRoom> findAll();
}
