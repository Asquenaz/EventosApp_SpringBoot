package com.eventoapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration // Informa ao Spring que a clase é de configuração
public class DataConfiguration {

    @Bean
    public DataSource dataSource(){
        try {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/eventosapp");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            return dataSource;

        }catch (Exception e){
            throw new IllegalArgumentException("Erro ao iniciar Banco" + e);
        }
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        try {
            HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
            adapter.setDatabase(Database.MYSQL);
            adapter.setShowSql(true); // Espécie de Logs de console
            adapter.setGenerateDdl(true); // Manda o hibernate criar tabelas
            adapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");//Usar dialeto de acrodo com a versão da dependência;
            adapter.setPrepareConnection(true); // Automatiza a conexões

            return adapter;
        }catch (Exception e){
            throw new IllegalArgumentException("Erro de criação de tabela" + e);
        }

    }
}
