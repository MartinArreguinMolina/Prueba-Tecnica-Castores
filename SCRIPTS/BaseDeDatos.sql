
CREATE SCHEMA IF NOT EXISTS pruebacastores DEFAULT CHARACTER SET utf8mb4;
USE pruebacastores;


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";



CREATE TABLE `historicos` (
                              `id_historico` int(11) NOT NULL,
                              `fecha` datetime(6) DEFAULT NULL,
                              `tipo` int(11) DEFAULT NULL,
                              `id_usuario` int(6) DEFAULT NULL,
                              `cantidad` int(11) DEFAULT NULL,
                              `id_producto` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
                             `id_producto` int(6) NOT NULL,
                             `cantidad` int(11) DEFAULT NULL,
                             `estatus` int(1) DEFAULT NULL,
                             `nombre` varchar(60) DEFAULT NULL,
                             `precio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
                         `id_rol` int(2) NOT NULL,
                         `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id_rol`, `nombre`) VALUES
                                             (1, 'Administrador'),
                                             (2, 'Almacenista');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
                            `estatus` int(1) DEFAULT NULL,
                            `id_rol` int(2) DEFAULT NULL,
                            `id_usuario` int(6) NOT NULL,
                            `contrasena` varchar(25) DEFAULT NULL,
                            `correo` varchar(50) DEFAULT NULL,
                            `nombre` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`estatus`, `id_rol`, `id_usuario`, `contrasena`, `correo`, `nombre`) VALUES
                                                                                                 (1, 1, 1, '12345678', 'martin@gmail.com', 'Martin'),
                                                                                                 (1, 2, 2, '12345678', 'jose@gmail.com', 'Jose');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `historicos`
--
ALTER TABLE `historicos`
    ADD PRIMARY KEY (`id_historico`),
  ADD KEY `fk_historico_user` (`id_usuario`),
  ADD KEY `fk_historico_producto` (`id_producto`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
    ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
    ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
    ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_user_rol` (`id_rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `historicos`
--
ALTER TABLE `historicos`
    MODIFY `id_historico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
    MODIFY `id_producto` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
    MODIFY `id_rol` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
    MODIFY `id_usuario` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historicos`
--
ALTER TABLE `historicos`
    ADD CONSTRAINT `fk_historico_producto` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  ADD CONSTRAINT `fk_historico_user` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
    ADD CONSTRAINT `fk_user_rol` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`);
COMMIT;
