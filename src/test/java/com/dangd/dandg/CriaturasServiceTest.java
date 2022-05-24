package com.dangd.dandg;

import com.dangd.dandg.domain.classes.Criatura;
import com.dangd.dandg.domain.dto.CriaturaDTO;
import com.dangd.dandg.domain.exception.ObjectNotFoundException;
import com.dangd.dandg.domain.services.CriaturaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CriaturasServiceTest {

	@Autowired
	private CriaturaService criaturaService;

	@Test
	public void testeManipulacaoCriatura() {
		//Cria e inicializa objeto de teste
		Criatura criatura = new Criatura();
		criatura.setNomeCriatura("Marcel");
		criatura.setTipoCriatura("Homunculo");

		//Executa o create e captura o DTO de retorno
		CriaturaDTO criaturaDTO = criaturaService.create(criatura);

		//Confere se o objeto de retorno não é nulo e se o id não é nulo
		Integer id = criaturaDTO.getIdCriatura();
		assertNotNull(criaturaDTO);
		assertNotNull(id);

		//Executa o get do id capturado anteriormente e verifica se é presente
		criaturaDTO = criaturaService.getCriaturaById(id);
		assertNotNull(criaturaDTO);

		//Compara se os dados do get são os mesmos que do objeto teste montado no inicio
		assertEquals(criatura.getNomeCriatura(), criaturaDTO.getNomeCriatura());
		assertEquals(criatura.getTipoCriatura(), criaturaDTO.getTipoCriatura());

		//Deleta pelo id e confere se não existe mais
		criaturaService.delete(id);
		try{
			criaturaService.getCriaturaById(id);
			fail("Criatura não foi excluida corretamente");
		}catch(ObjectNotFoundException exception){
			//OK
		}

	}

	@Test
	public void testeListagensCriaturas() {
		List<CriaturaDTO> criaturaDTOList = criaturaService.getCriaturas();
		assertEquals(5, criaturaDTOList.size());
	}

	@Test
	public void testeListagensCriaturasPorTipo() {
		assertEquals(3, criaturaService.getCriaturasByTipoCriatura("humanoide").size());
		assertEquals(1, criaturaService.getCriaturasByTipoCriatura("monstro").size());
		assertEquals(1, criaturaService.getCriaturasByTipoCriatura("besta").size());
		assertEquals(0, criaturaService.getCriaturasByTipoCriatura("anemona").size());
	}


}
