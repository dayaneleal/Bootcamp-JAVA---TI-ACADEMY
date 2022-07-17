use turmax;

-- listar o nome de cada material e o valor médio desse material

SELECT AVG(valor),nome FROM item_ordem_compra as ioc 
INNER JOIN material as m 
ON ioc.idMaterial = m.id group by nome;

-- listar o nome de cada material e o valor médio desse material entre os dias 10/05/2022 e 13/05/2022

SELECT nome,AVG(valor) FROM item_ordem_compra as ioc 
INNER JOIN material as m 
ON ioc.idMaterial = m.id
INNER JOIN ordem_compra as o
ON o.id = oc.idOrdemCompra
WHERE data BETWEEN '2022-05-10' AND '2022-05-13'
GROUP BY nome;

-- qual é o produto que mais aparece nas compras?

SELECT count(nome) as quantidade_de_pedidos ,nome FROM item_ordem_compra as ioc 
INNER JOIN material as m 
ON ioc.idMaterial = m.id
GROUP BY nome
ORDER BY quantidade_de_pedidos DESC;

-- O produto que mais aparece nas compras é o parafuso.

SELECT nome,SUM(quantidade) FROM item_ordem_compra as ioc 
INNER JOIN material as m 
ON ioc.idMaterial = m.id
GROUP BY nome
ORDER BY SUM(quantidade) DESC;

-- R: O produto mais vendido é o tijolo.

-- CRUD (insert, select, update, delete)
