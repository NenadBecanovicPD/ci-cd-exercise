package com.productdock.exercise_8;


public class Photographer {

  private Camera camera = new DigitalCamera();

  public void buyMoreMemory() {
    CameraMemorySupplier memorySupplier = new CameraMemorySupplier();
    memorySupplier.buyMoreMemory(camera);
  }

}
