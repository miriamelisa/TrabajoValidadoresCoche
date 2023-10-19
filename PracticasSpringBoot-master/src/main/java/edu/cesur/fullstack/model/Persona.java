package edu.cesur.fullstack.model; //se suelen poner domain o model

import edu.cesur.fullstack.validators.CodeValidation;
import edu.cesur.fullstack.validators.OnCreate;
import edu.cesur.fullstack.validators.OnUpdate;
import edu.cesur.fullstack.validators.ValidPersonCode;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

	@NotNull (groups = {OnCreate.class, OnUpdate.class})
	private Integer id;
	
	@NotBlank(message = "Debes ingresar un nombre válido" ,groups = OnCreate.class )
	private String name;
	
	@NotNull
    @Size(min=2, max=100) 
	private String lastName;
	
	
	private int age;
	
	@NotBlank (groups = OnCreate.class)
	@Email
	private String email;
	
	@CodeValidation
	private String code;

//	public Persona(int id, String name, String lastName, int age, String email, String code) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.lastName = lastName;
//		this.age = age;
//		this.email = email;
//		this.code = code;
//	}

//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	@Override
//	public String toString() {
//		return "Persona [id = " + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + "]";
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//	
//	

}
