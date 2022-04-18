package com.productdock.exercise_8;

public class CameraMemorySupplier {

  private PhotographyShopApi api;

  public void buyMoreMemory(Camera camera) {
    if (camera instanceof DigitalCamera) {
      orderMemoryCard((DigitalCamera)camera);
    } else if (camera instanceof AnalogueCamera) {
      orderFilm((AnalogueCamera)camera);
    }
  }

  private void orderMemoryCard(DigitalCamera camera) {
    String memoryCardType = camera.getMemoryCardType();
    api.placeAnOrder(memoryCardType);
  }

  private void orderFilm(AnalogueCamera camera) {
    String filmType = camera.getFilmType();
    api.placeAnOrder(filmType);
  }
}
