class Animal {
    constructor(especie, tamanho, biomas) {
        this.especie = especie;
        this.tamanho = tamanho;
        this.biomas = biomas;  // Mudança para representar vários biomas
    }
}

class RecintosZoo {

    constructor() {
        this.recintos = [
            { nome: 'Recinto 1', bioma: ['savana'], espacoLivre: 7, capacidadeTotal: 10, animais: ['macaco', 'macaco', 'macaco'] },
            { nome: 'Recinto 2', bioma: ['floresta'], espacoLivre: 5, capacidadeTotal: 5, animais: [] },
            { nome: 'Recinto 3', bioma: ['savana', 'rio'], espacoLivre: 5, capacidadeTotal: 7, animais: ['gazela'] },
            { nome: 'Recinto 4', bioma: ['rio'], espacoLivre: 8, capacidadeTotal: 8, animais: [] },
            { nome: 'Recinto 5', bioma: ['savana'], espacoLivre: 6, capacidadeTotal: 9, animais: ['leao'] }
        ];

        this.animais = [
            new Animal('LEAO', 3, ['savana']),
            new Animal('LEOPARDO', 2, ['savana']),
            new Animal('CROCODILO', 3, ['rio']),
            new Animal('MACACO', 1, ['savana', 'floresta']),
            new Animal('GAZELA', 2, ['savana']),
            new Animal('HIPOPOTAMO', 4, ['savana', 'rio'])
        ];
    }

    analisaRecintos(tpanimal, quantidade) {
        let resultado = { erro: null, recintosViaveis: [] };

        const selecionarAnimal = this.animais.find(animal => animal.especie === tpanimal);

        if (!selecionarAnimal) {
            return { erro: "Animal inválido" };
        }

        if (quantidade <= 0) {
            return { erro: "Quantidade inválida" };
        }

        const espacoNecessario = selecionarAnimal.tamanho * quantidade;

        let recintosFiltrados = this.recintos.filter(recinto => {
            let espacoExtra = (recinto.animais.length > 0 && !recinto.animais.includes(selecionarAnimal.especie)) ? 1 : 0;
            let espacoDisponivel = recinto.espacoLivre - espacoExtra;

            if (espacoDisponivel < espacoNecessario) return false;
            if (!selecionarAnimal.biomas.some(bioma => recinto.bioma.includes(bioma))) return false;
            
            if (selecionarAnimal.especie === 'HIPOPOTAMO' && recinto.bioma.length < 2) return false;
            if (selecionarAnimal.especie === 'MACACO' && recinto.animais.length === 0) return false;

            if (['LEAO', 'LEOPARDO', 'CROCODILO'].includes(selecionarAnimal.especie) && recinto.animais.length > 0) {
                return recinto.animais.every(animal => animal === selecionarAnimal.especie);
            }

            return true;
        });

        if (recintosFiltrados.length === 0) {
            resultado.erro = "Não há recinto viável";
            resultado.recintosViaveis = null;
        } else {
            resultado.recintosViaveis = recintosFiltrados.map(recinto => {
                let espacoLivreAposAdicionar = recinto.espacoLivre - espacoNecessario;
                return `${recinto.nome} (espaço livre: ${espacoLivreAposAdicionar} total: ${recinto.capacidadeTotal})`;
            });
        }

        return resultado;
    }
}

export { RecintosZoo as RecintosZoo };
