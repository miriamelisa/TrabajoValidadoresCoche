package edu.cesur.fullstack.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coche {
	@NotNull
	Integer id;
	String marca;
	String modelo;

}
