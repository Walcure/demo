package project.mougeot.example.controller;

import org.springframework.web.bind.annotation.*;
import project.mougeot.example.config.repository.CarRepository;
import project.mougeot.example.model.Car;

import java.util.List;

@RestController
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/car/all")
    public List<Car> all(){
        return carRepository.findAll();
    }


    @GetMapping("/car/get/{brand}")
    List<Car> getCarByBrand(@PathVariable String brand){
        return carRepository.findAllByBrand(brand);
    }

    @PostMapping("/car/create")
    Car createCar(@RequestBody Car car){
        return carRepository.save(car);
    }

    @PutMapping("/car/updateOrCreate/{id}")
    Car updateCar(@RequestBody Car car, @PathVariable Long id){
        return carRepository.findById(id)
                .map( dbCar -> {
                    dbCar.setBrand(car.getBrand());
                    dbCar.setModel(car.getModel());
                    dbCar.setPrice(car.getPrice());
                    return carRepository.save(dbCar);
                })
                .orElseGet(() -> carRepository.save(car));
    }

}