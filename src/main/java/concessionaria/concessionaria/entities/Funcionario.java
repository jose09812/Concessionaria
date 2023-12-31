package concessionaria.concessionaria.entities;

import java.util.List;

import org.springframework.beans.BeanUtils;

import concessionaria.concessionaria.Enum.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data   
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funcionarios")
public class Funcionario extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 11)
    private String ctps;
    private double salario;
    private Cargo cargo;
    @OneToMany(mappedBy = "funcionario")
    private List<Venda>  vendas;

    public void setFuncionario(Funcionario funcionarioAntigo, Funcionario funcionarioAtualizado){
          try {
        BeanUtils.copyProperties(funcionarioAntigo, funcionarioAtualizado);
    } catch (Exception e) {
       
    }
    }
    
}
