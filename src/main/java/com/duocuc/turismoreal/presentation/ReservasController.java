package com.duocuc.turismoreal.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duocuc.turismoreal.dto.Mensaje;
import com.duocuc.turismoreal.request.ActualizarCheckIn;
import com.duocuc.turismoreal.request.ActualizarCheckOut;
import com.duocuc.turismoreal.request.ActualizarReserva;
import com.duocuc.turismoreal.request.RegistrarReserva;
import com.duocuc.turismoreal.request.RegistrarReservaServicio;
import com.duocuc.turismoreal.request.RegistrarServicioTransporte;
import com.duocuc.turismoreal.response.CheckInResponse;
import com.duocuc.turismoreal.response.CheckOutResponse;
import com.duocuc.turismoreal.response.ReservaDepartamentoResponse;
import com.duocuc.turismoreal.response.ReservaResponse;
import com.duocuc.turismoreal.response.ReservaServicioResponse;
import com.duocuc.turismoreal.response.ReservaTransporteResponse;
import com.duocuc.turismoreal.service.ReservasService;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("reservas")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class ReservasController {

    @Autowired
    ReservasService reservasService;

    @PostMapping("/crear")
    public ResponseEntity<?> crearReserva(@RequestBody(required = true) RegistrarReserva registrarReserva) {

        reservasService.crearReserva(registrarReserva);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.CREATED);

    }

    @GetMapping("/listar-cliente/{runCliente}")
    public List<ReservaResponse> listarReservaCliente(@PathVariable("runCliente") String runCliente) {

        return reservasService.listarReservasCliente(runCliente);

    }

    @GetMapping("/listar")
    public List<ReservaResponse> listarReserva() {

        return reservasService.listarReservas();

    }

    @PostMapping("/crear-servicio")
    public ResponseEntity<?> crearReservaServicio(
            @RequestBody(required = true) RegistrarReservaServicio registrarReservaServicio) {

        reservasService.crearReservaServicio(registrarReservaServicio);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.CREATED);

    }

    @DeleteMapping("/borrar/{idReserva}")
    public ResponseEntity<?> borrarReserva(@PathVariable("idReserva") int idReserva) {

        reservasService.borrarReserva(idReserva);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.OK);

    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarReserva(@RequestBody(required = true) ActualizarReserva actualizarReserva) {

        reservasService.actualizarReserva(actualizarReserva);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.OK);

    }

    @GetMapping("/buscar-id/{idReserva}")
    public ReservaResponse buscarReservaPorId(@PathVariable("idReserva") int idReserva) {

        return reservasService.buscarReservaPorId(idReserva);

    }

    @GetMapping("/buscar-reserva-departamento/{idReserva}/{idDepartamento}")
    public ReservaDepartamentoResponse buscarReservaDepartamento(@PathVariable("idReserva") int idReserva,
            @PathVariable("idDepartamento") int idDepartamento) {

        return reservasService.buscarReservaDepartamento(idReserva, idDepartamento);

    }

    @GetMapping("/buscar-reserva-servicio/{idReserva}/{idServicio}")
    public ReservaServicioResponse buscarReservaServicio(@PathVariable("idReserva") int idReserva,
            @PathVariable("idServicio") int idServicio) {

        return reservasService.buscarReservaServicio(idReserva, idServicio);

    }

    @GetMapping("/buscar-check-in/{idReserva}")
    public CheckInResponse buscarCheckin(@PathVariable("idReserva") int idReserva){

        return reservasService.buscarCheckIn(idReserva);

    }

    @GetMapping("/buscar-check-out/{idReserva}")
    public CheckOutResponse buscarCheckout(@PathVariable("idReserva") int idReserva){

        return reservasService.buscarCheckOut(idReserva);

    }

    @GetMapping("/listar-check-in")
    public List<CheckInResponse> listarCheckIn(){

        return reservasService.listarCheckIn();

    }

    @GetMapping("/listar-check-out")
    public List<CheckOutResponse> listarCheckOut(){

        return reservasService.listarCheckOut();

    }

    @PutMapping("/actualizar-checkin")
    public ResponseEntity<?> actualizarCheckIn(@RequestBody(required = true)ActualizarCheckIn actualizarCheckIn ){

        reservasService.actualizarCheckIn(actualizarCheckIn);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.OK);

    }

    @PutMapping("/actualizar-checkout")
    public ResponseEntity<?> actualizarCheckOut(@RequestBody(required = true) ActualizarCheckOut actualizarCheckOut){

        reservasService.actualizarCheckOut(actualizarCheckOut);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.OK);
    }

    @PostMapping("/crear-reserva-transporte")
    public ResponseEntity<?> crearReservaTransporte(@RequestBody(required = true) RegistrarServicioTransporte servicioTransporte){

        reservasService.crearReservaTransporte(servicioTransporte);

        return new ResponseEntity<>(new Mensaje("ok"), HttpStatus.CREATED);

    }

    @GetMapping("/listar-reserva-transporte/{idReserva}")
    public List<ReservaTransporteResponse> listarReservaTransporte(@PathVariable("idReserva") int idReserva){

        return reservasService.listarReservaTransporte(idReserva);

    }


}
