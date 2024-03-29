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
package es.maquina.gae.pedidosjapon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.maquina.gae.pedidosjapon.persistencia.dominio.Pedido;
import es.maquina.gae.pedidosjapon.service.PedidoService;

@RestController("/pedidos")
public class PedidoControllerImpl implements PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@Override
	@PutMapping(path = "/guardarPedido")
	public void guardarPedido(@RequestBody Pedido pedido) {
		pedidoService.guardarPedido(pedido);
	}

	@Override
	@GetMapping(path = "/verPedidos")
	public List<Pedido> verPedidos() {
		return pedidoService.verPedidos();
	}

}
