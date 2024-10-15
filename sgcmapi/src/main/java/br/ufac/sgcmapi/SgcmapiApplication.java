package br.ufac.sgcmapi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import br.ufac.sgcmapi.model.Atendimento;
import br.ufac.sgcmapi.model.Paciente;
import br.ufac.sgcmapi.model.Profissional;
import br.ufac.sgcmapi.repository.AtendimentoRepository;

import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@RestController
public class SgcmapiApplication {


	@Autowired
	private AtendimentoRepository repo;

	@RequestMapping(value = "/teste")
	public String exemplo(){

		Atendimento atendimento01 = new Atendimento();
		Paciente paciente = new Paciente();
		paciente.setId(1L);

		Profissional profissional = new Profissional();
		profissional.setId(1L);

		atendimento01.setData(LocalDate.of(2024, 10, 11));
		atendimento01.setHora(LocalTime.of(15, 0));
		atendimento01.setPaciente(paciente);
		atendimento01.setProfissional(profissional);

		repo.save(atendimento01);

		List<Atendimento> atendimentos = repo.findAll();
		StringBuilder resultado = new StringBuilder();
		for (Atendimento atendimento : atendimentos) {
			resultado.append(atendimento.getId() + "\n");
			resultado.append(atendimento.getData() + "\n");
			resultado.append(atendimento.getHora() + "\n");
			resultado.append(atendimento.getStatus() + "\n");
			resultado.append(atendimento.getPaciente().getNome() + "\n");
			resultado.append(atendimento.getProfissional().getNome() + "\n");
			if (atendimento.getConvenio() != null) {
				resultado.append(atendimento.getConvenio().getNome() + "\n");
			}
			resultado.append("\n");
		}
		return resultado.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(SgcmapiApplication.class, args);
	}

}
