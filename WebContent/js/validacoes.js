function testaCPF(cpf)
  {	
	cpf = cpf.replace(/[^\d]+/g,'');
    var numeros, digitos, soma, i, resultado, digitos_iguais;
    digitos_iguais = 1;
    if (cpf.length < 11)
          return false;
    for (i = 0; i < cpf.length - 1; i++)
          if (cpf.charAt(i) != cpf.charAt(i + 1))
                {
                digitos_iguais = 0;
                break;
                }
    if (!digitos_iguais)
          {
          numeros = cpf.substring(0,9);
          digitos = cpf.substring(9);
          soma = 0;
          for (i = 10; i > 1; i--)
                soma += numeros.charAt(10 - i) * i;
          resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
          if (resultado != digitos.charAt(0))
                return false;
          numeros = cpf.substring(0,10);
          soma = 0;
          for (i = 11; i > 1; i--)
                soma += numeros.charAt(11 - i) * i;
          resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
          if (resultado != digitos.charAt(1))
                return false;
          return true;
          }
    else
        return false;
  }

function testaRg(strRg) {
	if (strRg == "00.000.000-0") {
		return false;
	}
	return true;

}


function testaData(data) {
	data = data.replace(/\//g, "-");
	var data_array = data.split("-"); 

	if (data_array[0].length != 4) {
		data = data_array[2] + "-" + data_array[1] + "-" + data_array[0]; 
	}

	var hoje = new Date();
	var nasc = new Date(data);
	if (nasc >= hoje) {
		return false;
	} else {
		return true;
	}

}
