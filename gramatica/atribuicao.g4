grammar atribuicao;

init: tipo id op num fim;

tipo: 'inteiro' | 'palavra' | 'flutuante';

op: '<-';
fim: '.';
id: ID;
ID: [a-z]+;
num: NUM;
NUM: [0-9]+;

Ws: [ \t\r\n]+ -> skip;
