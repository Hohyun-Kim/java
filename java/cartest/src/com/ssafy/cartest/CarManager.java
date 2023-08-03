package com.ssafy.cartest;

import java.util.List;

public interface CarManager {
  void add(Car car) throws SameNumberException;

  List<Car> search();

  Car searchByNum(int carNum) throws NotFoundException;

  void deleteCar(String carName);

  void save();

  List<Car> load();
}
