grammar atribuicao;

init: comando+;
comando: tipo id op (id|num) fim;


tipo: 'inteiro' {System.out.print("int ");} | 'decimal' {System.out.print("float ");} | 'palavra' {System.out.print("String ");};

op: '<-' {System.out.print("= ");};
fim: '.' {System.out.print("; ");};
id: ID {System.out.print($ID.text);};
ID: [a-z]+;
num: NUM {System.out.print($NUM.text);};
NUM: [0-9]+;

Ws: [ \t\r\n]+ -> skip;
