package com.ssafy.cartest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarManagerImpl implements CarManager {
  List<Car> list = new ArrayList<Car>();

  // Singleton 구현
  private static CarManager carManager = new CarManagerImpl();

  private CarManagerImpl() {}

  public static CarManager getCarManager() {
    return carManager;
  }

  @Override
  public void add(Car car) throws SameNumberException {
    for (Car carInList : list) {
      if (carInList.getCarNum() == car.getCarNum()) {
        throw new SameNumberException("SameNumberException 발생 : " + car.getCarNum() + "은 이미 등록!!!");
      }
    }
    list.add(car);
  }

  @Override
  public List<Car> search() {
    Collections.sort(list);
    return list;
  }

  @Override
  public Car searchByNum(int carNum) throws NotFoundException {
    for (Car carInList : list) {
      if (carInList.getCarNum() == carNum) {
        return carInList;
      }
    }
    throw new NotFoundException("NotFoundException 발생 : " + carNum + "은 미등록 차량!!");
  }

  // car.dat list객체 저장
  @Override
  public void save() {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("car.dat"))) {
      out.writeObject(list);
      out.flush();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    // ObjectOutputStream out = null;
    // try {
    // out = new ObjectOutputStream(new FileOutputStream("car.dat"));
    // out.writeObject(list);
    // out.flush();
    // } catch (FileNotFoundException e) {
    // e.printStackTrace();
    // } catch (IOException e) {
    // e.printStackTrace();
    // } finally {
    // try {
    // if (out != null)
    // out.close();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
  }

  @Override
  public List<Car> load() {
    File file = new File("car.dat");
    if (file.exists()) {
      ObjectInputStream in = null;
      try {
        in = new ObjectInputStream(new FileInputStream(file));
        list = (List<Car>) in.readObject();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } finally {
        try {
          if (in != null)
            in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return list;
    } else {
      return Collections.EMPTY_LIST;
    }
  }

  @Override
  public void deleteCar(String carName) {

    for (int i = list.size() - 1; i >= 0; i--) {
      if (list.get(i).getCarName().equals(carName)) {
        list.remove(i);
      }
    }

  }

}
