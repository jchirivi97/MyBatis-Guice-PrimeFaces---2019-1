/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @param idcli 
     * @throws SQLException 
     * 8888888
     */
    public static void main(String args[] ) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        SqlSession sqlss = sessionfact.openSession();
        ClienteMapper cm=sqlss.getMapper(ClienteMapper.class);
      //** consult of client with number document 
        //System.out.println(cm.consultarClientes(123456));
        
        //insert in table ItemRentado
        java.util.Date d = new java.util.Date();  
        java.util.Date d2 = new java.util.Date();  
        java.sql.Date date1 = new java.sql.Date(d.getTime());
        java.sql.Date date2 = new java.sql.Date(d2.getTime());
        //cm.agregarItemRentadoACliente(66,2107356,4, date1, date2);
        
        //insert in table Item 
        java.sql.Date date3 = new java.sql.Date(d.getTime());
        ItemMapper im=sqlss.getMapper(ItemMapper.class);
        TipoItem tipo = new TipoItem(2,"Accion");
        Item item = new Item(tipo,7,"la comuna 13","eventos de la comuna 13 de medellin",date3,12000,"formato de renta","violencia");
        //im.insertarItem(item);
        
        //** consult of item with number id 
        //System.out.println(im.consultarItem(7));
        
        sqlss.commit();
        
        
        sqlss.close();

        
        
    }


}
