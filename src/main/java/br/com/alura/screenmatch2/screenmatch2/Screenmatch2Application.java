package br.com.alura.screenmatch2.screenmatch2;

import br.com.alura.screenmatch2.screenmatch2.model.DadosEpisodio;
import br.com.alura.screenmatch2.screenmatch2.model.DadosSerie;
import br.com.alura.screenmatch2.screenmatch2.model.DadosTemporada;
import br.com.alura.screenmatch2.screenmatch2.service.ConsumoApi;
import br.com.alura.screenmatch2.screenmatch2.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Screenmatch2Application implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(Screenmatch2Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        var consumoApi = new ConsumoApi();
        var json = ConsumoApi.obterDados("https://www.omdbapi.com/?t=friends&apikey=98437a33");
        System.out.println(json);
        ConverteDados conversor = new ConverteDados();
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);
        json = consumoApi.obterDados("https://www.omdbapi.com/?t=friends&season=1&episode=1&apikey=98437a33");
        DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
        System.out.println(dadosEpisodio);

        List<DadosTemporada> temporadas = new ArrayList<>();

        for (int i = 0; i <=dados.totalTemporadas(); i++) {
            json = consumoApi.obterDados("https://www.omdbapi.com/?t=friends&season="+ i +"&apikey=98437a33");
            DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(System.out::println);

    }

}
