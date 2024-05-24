package com.institute.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;

import com.institute.one.users.domain.entity.PermissionEntity;
import com.institute.one.users.domain.entity.RoleEntity;
import com.institute.one.users.domain.entity.UserEntity;
import com.institute.one.users.persistence.repository.IUserRepository;
import com.institute.one.utilities.enums.DocTypeEnum;
import com.institute.one.utilities.enums.GenderEnum;
import com.institute.one.utilities.enums.RoleEnum;
import com.institute.one.utilities.enums.StateEnum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class OneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneApplication.class, args);
	}

	// @Bean
	// CommandLineRunner init(IUserRepository userRepository) {

	// 	return args -> {

	// 		// System.out.println("Hello World");

	// 		PermissionEntity crearPermission = PermissionEntity.builder()
	// 				.name("CREAR")
	// 				.build();

	// 		PermissionEntity leerPermission = PermissionEntity.builder()
	// 				.name("LEER")
	// 				.build();

	// 		PermissionEntity actualizarPermission = PermissionEntity.builder()
	// 				.name("ACTUALIZAR")
	// 				.build();

	// 		PermissionEntity borrarPermission = PermissionEntity.builder()
	// 				.name("BORRAR")
	// 				.build();

	// 		PermissionEntity modificarPermission = PermissionEntity.builder()
	// 				.name("MODIFICAR")
	// 				.build();
	// 		PermissionEntity evaluarPermission = PermissionEntity.builder()
	// 				.name("EVALUAR")
	// 				.build();
	// 		PermissionEntity administrarPermission = PermissionEntity.builder()
	// 				.name("ADMINISTAR")
	// 				.build();
	// 		PermissionEntity pagarPermission = PermissionEntity.builder()
	// 				.name("PAGAR")
	// 				.build();
	// 		PermissionEntity realizarPermission = PermissionEntity.builder()
	// 				.name("REALIZAR")
	// 				.build();
	// 		PermissionEntity desarrollarPermission = PermissionEntity.builder()
	// 				.name("DESAROLLAR")
	// 				.build();

	// 		RoleEntity rolAdministrador = RoleEntity.builder()
	// 				.roleEnum(RoleEnum.ADMINISTRADOR)
	// 				.permissionList(Set.of(administrarPermission, leerPermission, modificarPermission,
	// 						actualizarPermission, borrarPermission))
	// 				.build();

	// 		RoleEntity rolProfesor = RoleEntity.builder()
	// 				.roleEnum(RoleEnum.PROFESOR)
	// 				.permissionList(Set.of(evaluarPermission, leerPermission, actualizarPermission, borrarPermission))
	// 				.build();

	// 		RoleEntity rolAlumno = RoleEntity.builder()
	// 				.roleEnum(RoleEnum.ALUMNO)
	// 				.permissionList(Set.of(realizarPermission, leerPermission, actualizarPermission))
	// 				.build();

	// 		RoleEntity rolAcudiente = RoleEntity.builder()
	// 				.roleEnum(RoleEnum.ACUDIENTE)
	// 				.permissionList(Set.of(pagarPermission, leerPermission, actualizarPermission))
	// 				.build();

	// 		RoleEntity rolDesarrollador = RoleEntity.builder()
	// 				.roleEnum(RoleEnum.DESARROLLADOR)
	// 				.permissionList(
	// 						Set.of(desarrollarPermission, administrarPermission, evaluarPermission, pagarPermission,
	// 								leerPermission, modificarPermission, actualizarPermission, borrarPermission))
	// 				.build();

	// 		//TODO: date formatter			
	// 		String strDate = "2024-05-24"; // String representation of date
	// 		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE; // ISO-8601 date format

	// 		// Parse the String into a LocalDate object
	// 		LocalDate localDate = LocalDate.parse(strDate, formatter);

	// 		UserEntity userManuel = UserEntity.builder()
	// 				.username("manuel")
	// 				.password("1234")
	// 				.isEnabled(true)
	// 				.AccountNoExpired(true)
	// 				.AccountNoLocked(true)
	// 				.CredentialNoExpired(true)
	// 				.roles(Set.of(rolDesarrollador, rolAdministrador))
	// 				.name("manuel")
	// 				.surname("vela")
	// 				.docType(DocTypeEnum.CEDULA_CIUDADANIA)
	// 				.docNumber("12345678")
	// 				.birthDate(localDate)
	// 				.email("email@gmail.com")
	// 				.phone("3452345235")
	// 				.gender(GenderEnum.MASCULINO)
	// 				.profileImage("urldelaImagen")
	// 				.nickname("kaos")
	// 				.state(StateEnum.ACTIVO)
	// 				.build();

	// 		UserEntity useFernando = UserEntity.builder()
	// 				.username("fernando")
	// 				.password("1234")
	// 				.isEnabled(true)
	// 				.AccountNoExpired(true)
	// 				.AccountNoLocked(true)
	// 				.CredentialNoExpired(true)
	// 				.roles(Set.of(rolDesarrollador, rolProfesor))
	// 				.name("fernando")
	// 				.surname("osorio")
	// 				.docType(DocTypeEnum.CEDULA_CIUDADANIA)
	// 				.docNumber("57457")
	// 				.birthDate(localDate)
	// 				.email("email@gmail.com")
	// 				.phone("34252345")
	// 				.gender(GenderEnum.MASCULINO)
	// 				.profileImage("urldelaImagen")
	// 				.nickname("fercho")
	// 				.state(StateEnum.ACTIVO)
	// 				.build();

	// 		UserEntity userGeraldine = UserEntity.builder()
	// 				.username("geraldine")
	// 				.password("1234")
	// 				.isEnabled(true)
	// 				.AccountNoExpired(true)
	// 				.AccountNoLocked(true)
	// 				.CredentialNoExpired(true)
	// 				.roles(Set.of(rolAlumno, rolAdministrador))
	// 				.name("gerald")
	// 				.surname("leyton")
	// 				.docType(DocTypeEnum.CEDULA_CIUDADANIA)
	// 				.docNumber("12345678")
	// 				.birthDate(localDate)
	// 				.email("email@gmail.com")
	// 				.phone("3452345235")
	// 				.gender(GenderEnum.FEMENINO)
	// 				.profileImage("urldelaImagen")
	// 				.nickname("yeya")
	// 				.state(StateEnum.ACTIVO)
	// 				.build();

	// 		UserEntity userAlejandra = UserEntity.builder()
	// 				.username("alejandra")
	// 				.password("1234")
	// 				.isEnabled(true)
	// 				.AccountNoExpired(true)
	// 				.AccountNoLocked(true)
	// 				.CredentialNoExpired(true)
	// 				.roles(Set.of(rolAcudiente ))
	// 				.name("alejandra")
	// 				.surname("rojas")
	// 				.docType(DocTypeEnum.CEDULA_CIUDADANIA)
	// 				.docNumber("12345678")
	// 				.birthDate(localDate)
	// 				.email("email@gmail.com")
	// 				.phone("3452345235")
	// 				.gender(GenderEnum.FEMENINO)
	// 				.profileImage("urldelaImagen")
	// 				.nickname("ale")
	// 				.state(StateEnum.ACTIVO)
	// 				.build();

	// 		UserEntity userEliana = UserEntity.builder()
	// 				.username("eliana")
	// 				.password("1234")
	// 				.isEnabled(true)
	// 				.AccountNoExpired(true)
	// 				.AccountNoLocked(true)
	// 				.CredentialNoExpired(true)
	// 				.roles(Set.of(rolDesarrollador, rolAdministrador))
	// 				.name("eliana")
	// 				.surname("perez")
	// 				.docType(DocTypeEnum.CEDULA_CIUDADANIA)
	// 				.docNumber("547457")
	// 				.birthDate(localDate)
	// 				.email("email@gmail.com")
	// 				.phone("2435234")
	// 				.gender(GenderEnum.FEMENINO)
	// 				.profileImage("urldelaImagen")
	// 				.nickname("eli")
	// 				.state(StateEnum.ACTIVO)
	// 				.build();
			
			
					

	// 		userRepository.saveAll(Set.of(userManuel,useFernando,userGeraldine,userAlejandra,userEliana));
	// 	};
	// }

}
