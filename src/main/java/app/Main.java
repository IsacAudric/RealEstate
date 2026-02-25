package app;

import dto.CreatePropertyDTO;
import model.Property;
import repository.InMemoryRepository;
import service.PropertyService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InMemoryRepository<Property> repo = new InMemoryRepository<>();
        PropertyService service = new PropertyService(repo);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Imobiliária - Menu ===");
            System.out.println("1. Cadastrar imóvel");
            System.out.println("2. Listar imóveis");
            System.out.println("3. Buscar imóvel por id");
            System.out.println("4. Remover imóvel");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            String opt = scanner.nextLine().trim();

            switch (opt) {
                case "1":
                    System.out.print("Título: ");
                    String title = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String address = scanner.nextLine();
                    System.out.print("Preço: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Nome do proprietário: ");
                    String ownerName = scanner.nextLine();
                    System.out.print("Telefone do proprietário: ");
                    String ownerPhone = scanner.nextLine();

                    CreatePropertyDTO dto = new CreatePropertyDTO(title, address, price, ownerName, ownerPhone);
                    Property created = service.createProperty(dto);
                    System.out.println("Imóvel criado: " + created.getId());
                    break;

                case "2":
                    List<Property> list = service.listAll();
                    if (list.isEmpty()) System.out.println("Nenhum imóvel cadastrado.");
                    else list.forEach(System.out::println);
                    break;

                case "3":
                    System.out.print("ID do imóvel: ");
                    String id = scanner.nextLine();
                    Optional<Property> found = service.getById(id);
                    System.out.println(found.map(Object::toString).orElse("Imóvel não encontrado."));
                    break;

                case "4":
                    System.out.print("ID do imóvel a remover: ");
                    String removeId = scanner.nextLine();
                    boolean removed = service.delete(removeId);
                    System.out.println(removed ? "Removido com sucesso." : "ID não encontrado.");
                    break;

                case "0":
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida.");
                }
            }
        }
    }