/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.maquina.gae.pedidosjapon.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.maquina.gae.pedidosjapon.persistencia.dominio.Pedido;
import es.maquina.gae.pedidosjapon.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public String guardarPedido(String nombrePedido) {

		String respuesta = "Se ha guardado el pedido satisfactoriamente";

		if (StringUtils.isBlank(nombrePedido) == Boolean.FALSE) {
			pedidoRepository.save(nombrePedido);
		} else {
			respuesta = "El nombre de pedido no debe ser nulo vacío o con solo espacios";
		}

		return respuesta;
	}

	@Override
	public List<Pedido> verPedidos() {
		return pedidoRepository.findAll();
	}

}
