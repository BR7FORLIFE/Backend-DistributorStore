// package com.tecno_comfenalco.pa.config;

// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Random;
// import java.util.Set;

// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.github.javafaker.Faker;
// import com.tecno_comfenalco.pa.application.auth.ports.IUserRepositoryPort;
// import com.tecno_comfenalco.pa.features.catalog.models.CatalogModel;
// import com.tecno_comfenalco.pa.features.catalog.models.ProductCatalogModel;
// import com.tecno_comfenalco.pa.features.catalog.ports.ICatalogRepositoryPort;
// import com.tecno_comfenalco.pa.features.catalog.ports.IProductsCatalogRepositoryPort;
// import com.tecno_comfenalco.pa.features.category.models.CategoryModel;
// import com.tecno_comfenalco.pa.features.category.ports.ICategoryRepositoryPort;
// import com.tecno_comfenalco.pa.features.distributor.models.DistributorModel;
// import com.tecno_comfenalco.pa.features.distributor.ports.IDistributorRepositoryPort;
// import com.tecno_comfenalco.pa.features.order.models.OrderDetaildEmbeddedModel;
// import com.tecno_comfenalco.pa.features.order.models.OrderDetailsModel;
// import com.tecno_comfenalco.pa.features.order.models.OrderModel;
// import com.tecno_comfenalco.pa.features.order.port.IOrderRepositoryPort;
// import com.tecno_comfenalco.pa.features.presales.models.PresalesModel;
// import com.tecno_comfenalco.pa.features.presales.ports.IPresalesRepositoryPort;
// import com.tecno_comfenalco.pa.features.product.models.ProductModel;
// import com.tecno_comfenalco.pa.features.product.ports.IProductRepositoryPort;
// import com.tecno_comfenalco.pa.features.store.models.StoreDistributorModel;
// import com.tecno_comfenalco.pa.features.store.models.StoreModel;
// import com.tecno_comfenalco.pa.features.store.ports.IStoreDistributorRepositoryPort;
// import com.tecno_comfenalco.pa.features.store.ports.IStoreRepositoryRepositoryPort;
// import com.tecno_comfenalco.pa.security.model.UserModel;
// import com.tecno_comfenalco.pa.shared.dto.DirectionDto;
// import com.tecno_comfenalco.pa.shared.enums.DocumentTypeEnum;
// import com.tecno_comfenalco.pa.shared.enums.StoreClaimStatus;

// import lombok.extern.slf4j.Slf4j;

// @Service
// @Slf4j
// public class DataSeederService {
//     // @Qualifier("IPostgresUserRepositoryAdapter")
//     @Qualifier("IMongoUserRepositoryAdapter")
//     private final IUserRepositoryPort userRepository;

//     // @Qualifier("IPostgresDistributorRepositoryAdapter")
//     @Qualifier("IMongoDistributorRepositoryAdapter")
//     private final IDistributorRepositoryPort distributorRepository;

//     // @Qualifier("IPostgresStoreRepositoryAdapter")
//     @Qualifier("IMongoStoreRepositoryAdapter")
//     private final IStoreRepositoryRepositoryPort storeRepository;

//     // @Qualifier("IPostgresPresalesRepositoryAdapter")
//     @Qualifier("IMongoPresalesRepositoryAdapter")
//     private final IPresalesRepositoryPort presalesRepository;

//     // @Qualifier("IPostgresCatalogRepositoryAdapter")
//     @Qualifier("IMongoCatalogRepositoryAdapter")
//     private final ICatalogRepositoryPort catalogRepository;

//     // @Qualifier("IPostgresCategoryRepositoryAdapter")
//     @Qualifier("IMongoCategoryRepositoryAdapter")
//     private final ICategoryRepositoryPort categoryRepository;

//     // @Qualifier("IPostgresProductRepositoryAdapter")
//     @Qualifier("IMongoProductRepositoryAdapter")
//     private final IProductRepositoryPort productRepository;

//     // @Qualifier("IPostgresOrderRepositoryAdapter")
//     @Qualifier("IMongoOrderRepositoryAdapter")
//     private final IOrderRepositoryPort orderRepository;

//     // @Qualifier("IPostgresStoresDistributorsRepositoryAdapter")
//     @Qualifier("IMongoStoreDistributorRepositoryAdapter")
//     private final IStoreDistributorRepositoryPort storesDistributorsRepository;

//     // @Qualifier("IPostgresProductsCatalogRepositoryAdapter")
//     @Qualifier("IMongoProductCatalogRepositoryAdapter")
//     private final IProductsCatalogRepositoryPort productsCatalogRepository;

//     private final PasswordEncoder passwordEncoder;

//     private final Faker faker = new Faker();
//     private final Random random = new Random();

//     public DataSeederService(
//             @Qualifier("IMongoUserRepositoryAdapter") IUserRepositoryPort userRepository,
//             @Qualifier("IMongoDistributorRepositoryAdapter") IDistributorRepositoryPort distributorRepository,
//             @Qualifier("IMongoStoreRepositoryAdapter") IStoreRepositoryRepositoryPort storeRepository,
//             @Qualifier("IMongoPresalesRepositoryAdapter") IPresalesRepositoryPort presalesRepository,
//             @Qualifier("IMongoCatalogRepositoryAdapter") ICatalogRepositoryPort catalogRepository,
//             @Qualifier("IMongoCategoryRepositoryAdapter") ICategoryRepositoryPort categoryRepository,
//             @Qualifier("IMongoProductRepositoryAdapter") IProductRepositoryPort productRepository,
//             @Qualifier("IMongoOrderRepositoryAdapter") IOrderRepositoryPort orderRepository,
//             @Qualifier("IMongoStoreDistributorRepositoryAdapter") IStoreDistributorRepositoryPort storesDistributorsRepository,
//             @Qualifier("IMongoProductCatalogRepositoryAdapter") IProductsCatalogRepositoryPort productsCatalogRepository,
//             PasswordEncoder passwordEncoder) {
//         this.userRepository = userRepository;
//         this.distributorRepository = distributorRepository;
//         this.storeRepository = storeRepository;
//         this.presalesRepository = presalesRepository;
//         this.catalogRepository = catalogRepository;
//         this.categoryRepository = categoryRepository;
//         this.productRepository = productRepository;
//         this.orderRepository = orderRepository;
//         this.storesDistributorsRepository = storesDistributorsRepository;
//         this.productsCatalogRepository = productsCatalogRepository;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @Transactional
//     public void seedDatabase(int totalRecords) {
//         log.info("Iniciando generación de {} registros falsos...", totalRecords);

//         // 1. Crear distribuidoras (10% de los registros) - cada una con su usuario
//         // dedicado
//         List<DistributorModel> distributors = createDistributors(totalRecords / 100);
//         log.info("Creadas {} distribuidoras con sus usuarios", distributors.size());

//         // 2. Crear preventa (5% de los registros) - cada uno con su usuario dedicado y
//         // asociado a un distribuidor
//         List<PresalesModel> presalesList = createPresales(distributors, totalRecords / 200);
//         log.info("Creados {} preventistas con sus usuarios", presalesList.size());

//         // 3. Crear tiendas (15% de los registros) - cada una con su usuario dedicado
//         List<StoreModel> stores = createStores(totalRecords / 7);
//         log.info("Creadas {} tiendas con sus usuarios", stores.size());

//         // 5. Crear relaciones tiendas-distribuidoras
//         createStoresDistributors(stores, distributors);
//         log.info("Creadas relaciones tiendas-distribuidoras");

//         // 6. Crear catálogos (uno por distribuidora)
//         List<CatalogModel> catalogs = createCatalogs(distributors);
//         log.info("Creados {} catálogos", catalogs.size());

//         // 7. Crear categorías (5 por catálogo)
//         List<CategoryModel> categories = createCategories(catalogs);
//         log.info("Creadas {} categorías", categories.size());

//         // 8. Crear productos (40% de los registros)
//         List<ProductModel> products = createProducts(distributors, totalRecords * 2 / 5);
//         log.info("Creados {} productos", products.size());

//         // 9. Vincular productos con categorías
//         linkProductsToCategories(products, categories);
//         log.info("Productos vinculados a categorías");

//         // 10. Crear órdenes (30% de los registros)
//         createOrders(stores, presalesList, distributors, products, totalRecords * 3 / 10);
//         log.info("Creadas órdenes con sus detalles");

//         log.info("Generación de datos completada exitosamente!");
//     }

//     /**
//      * Crea UN usuario dedicado para UN distribuidor con rol DISTRIBUTOR
//      */
//     private List<DistributorModel> createDistributors(int count) {
//         List<DistributorModel> distributors = new ArrayList<>();
//         for (int i = 0; i < count; i++) {
//             // Crear usuario específico para este distribuidor
//             UserModel user = UserModel.builder()
//                     .username(faker.internet().emailAddress())
//                     .password(passwordEncoder.encode("password123"))
//                     .enabled(true)
//                     .roles(Set.of("DISTRIBUTOR")) // Solo rol DISTRIBUTOR
//                     .build();
//             user = userRepository.save(user);

//             // Crear distribuidor vinculado al usuario
//             DistributorModel distributor = new DistributorModel();
//             distributor.setNIT(Long.valueOf(faker.number().digits(9)));
//             distributor.setName(faker.company().name());
//             distributor.setPhoneNumber(faker.phoneNumber().cellPhone());
//             distributor.setEmail(faker.internet().emailAddress());
//             distributor.setDirection(createRandomDirection());
//             distributor.setUser(user);
//             distributors.add(distributorRepository.save(distributor));
//         }
//         return distributors;
//     }

//     /**
//      * Crea UN usuario dedicado para UN preventista con rol PRESALES
//      * Cada preventista DEBE estar asociado a UN distribuidor
//      */
//     private List<PresalesModel> createPresales(List<DistributorModel> distributors, int count) {
//         List<PresalesModel> presalesList = new ArrayList<>();

//         // Primero, asignar al menos un preventista a cada distribuidora
//         int minIndex = Math.min(count, distributors.size());
//         for (int i = 0; i < minIndex; i++) {
//             // Crear usuario específico para este preventista
//             UserModel user = UserModel.builder()
//                     .username(faker.internet().emailAddress())
//                     .password(passwordEncoder.encode("password123"))
//                     .enabled(true)
//                     .roles(Set.of("PRESALES")) // Solo rol PRESALES
//                     .build();
//             user = userRepository.save(user);

//             // Crear preventista vinculado al usuario y al distribuidor
//             PresalesModel presales = new PresalesModel();
//             presales.setName(faker.name().fullName());
//             presales.setPhoneNumber(faker.phoneNumber().cellPhone());
//             presales.setEmail(faker.internet().emailAddress());
//             presales.setDocumentType(getRandomDocumentType());
//             presales.setDocumentNumber(Long.valueOf(faker.number().digits(10)));
//             presales.setUser(user);
//             // Asignar secuencialmente para garantizar que cada distribuidora tenga al menos
//             // uno
//             presales.setDistributor(distributors.get(i % distributors.size()));
//             presalesList.add(presalesRepository.save(presales));
//         }

//         // Luego, crear el resto de preventistas con distribuidoras aleatorias
//         for (int i = minIndex; i < count; i++) {
//             // Crear usuario específico para este preventista
//             UserModel user = UserModel.builder()
//                     .username(faker.internet().emailAddress())
//                     .password(passwordEncoder.encode("password123"))
//                     .enabled(true)
//                     .roles(Set.of("PRESALES")) // Solo rol PRESALES
//                     .build();
//             user = userRepository.save(user);

//             // Crear preventista vinculado al usuario y a un distribuidor aleatorio
//             PresalesModel presales = new PresalesModel();
//             presales.setName(faker.name().fullName());
//             presales.setPhoneNumber(faker.phoneNumber().cellPhone());
//             presales.setEmail(faker.internet().emailAddress());
//             presales.setDocumentType(getRandomDocumentType());
//             presales.setDocumentNumber(Long.valueOf(faker.number().digits(10)));
//             presales.setUser(user);
//             presales.setDistributor(distributors.get(random.nextInt(distributors.size())));
//             presalesList.add(presalesRepository.save(presales));
//         }

//         return presalesList;
//     }

//     /**
//      * Crea UN usuario dedicado para UNA tienda con rol STORE
//      */
//     private List<StoreModel> createStores(int count) {
//         List<StoreModel> stores = new ArrayList<>();
//         for (int i = 0; i < count; i++) {
//             // Crear usuario específico para esta tienda
//             UserModel user = UserModel.builder()
//                     .username(faker.internet().emailAddress())
//                     .password(passwordEncoder.encode("password123"))
//                     .enabled(true)
//                     .roles(Set.of("STORE")) // Solo rol STORE
//                     .build();
//             user = userRepository.save(user);

//             // Crear tienda vinculada al usuario
//             StoreModel store = new StoreModel();
//             store.setNIT(Long.valueOf(faker.number().digits(9)));
//             store.setName(faker.company().name() + " Store");
//             store.setPhoneNumber(faker.phoneNumber().cellPhone());
//             store.setEmail(faker.internet().emailAddress());
//             store.setDirection(createRandomDirection());
//             store.setUser(user);
//             store.setClaimStatus(getRandomClaimStatus());
//             stores.add(storeRepository.save(store));
//         }
//         return stores;
//     }

//     private void createStoresDistributors(List<StoreModel> stores, List<DistributorModel> distributors) {
//         for (StoreModel store : stores) {
//             // Cada tienda se asocia con 1-3 distribuidoras
//             int numDistributors = random.nextInt(3) + 1;
//             for (int i = 0; i < numDistributors; i++) {
//                 StoreDistributorModel sd = new StoreDistributorModel();
//                 sd.setStore(store);
//                 sd.setDistributor(distributors.get(random.nextInt(distributors.size())));
//                 sd.setInternalClientCode("CLIENT-" + faker.number().digits(6));
//                 storesDistributorsRepository.save(sd);
//             }
//         }
//     }

//     private List<CatalogModel> createCatalogs(List<DistributorModel> distributors) {
//         List<CatalogModel> catalogs = new ArrayList<>();
//         for (DistributorModel distributor : distributors) {
//             CatalogModel catalog = new CatalogModel();
//             catalog.setDistributor(distributor);
//             catalogs.add(catalogRepository.save(catalog));
//         }
//         return catalogs;
//     }

//     private List<CategoryModel> createCategories(List<CatalogModel> catalogs) {
//         List<CategoryModel> categories = new ArrayList<>();
//         String[] categoryNames = { "Bebidas", "Snacks", "Lácteos", "Carnes", "Frutas", "Verduras", "Panadería",
//                 "Limpieza", "Aseo Personal", "Electrónica" };

//         for (CatalogModel catalog : catalogs) {
//             for (String categoryName : categoryNames) {
//                 CategoryModel category = new CategoryModel();
//                 category.setName(categoryName);
//                 category.setCatalog(catalog);
//                 categories.add(categoryRepository.save(category));
//             }
//         }
//         return categories;
//     }

//     private List<ProductModel> createProducts(List<DistributorModel> distributors, int count) {
//         List<ProductModel> products = new ArrayList<>();
//         ProductModel.Unit[] units = ProductModel.Unit.values();

//         for (int i = 0; i < count; i++) {
//             ProductModel product = new ProductModel();
//             product.setName(faker.commerce().productName());
//             product.setPrice(Double.valueOf(faker.commerce().price().replace(",", "")));
//             product.setUnit(units[random.nextInt(units.length)]);
//             product.setDistributor(distributors.get(random.nextInt(distributors.size())));
//             products.add(productRepository.save(product));
//         }
//         return products;
//     }

//     private void linkProductsToCategories(List<ProductModel> products, List<CategoryModel> categories) {
//         if (categories.isEmpty() || products.isEmpty()) {
//             log.warn("No hay categorías o productos para vincular");
//             return;
//         }

//         int linksCreated = 0;

//         for (ProductModel product : products) {

//             // asegurar que el producto tiene ID persistido
//             if (product.getId() == null) {
//                 product = productRepository.save(product);
//             }

//             int numCategories = random.nextInt(3) + 1;
//             Set<CategoryModel> selectedCategories = new HashSet<>();

//             while (selectedCategories.size() < numCategories && selectedCategories.size() < categories.size()) {
//                 selectedCategories.add(categories.get(random.nextInt(categories.size())));
//             }

//             ProductCatalogModel mainRelation = null;

//             for (CategoryModel category : selectedCategories) {

//                 // asegurar que la categoría tiene ID
//                 if (category.getId() == null) {
//                     category = categoryRepository.save(category);
//                 }

//                 ProductCatalogModel productCatalog = new ProductCatalogModel();
//                 productCatalog.setProduct(product);
//                 productCatalog.setCategory(category);

//                 productCatalog = productsCatalogRepository.save(productCatalog);

//                 if (mainRelation == null) {
//                     mainRelation = productCatalog;
//                 }

//                 linksCreated++;
//             }

//             if (mainRelation != null) {
//                 product.setCategoryProduct(mainRelation);
//                 productRepository.save(product);
//             }
//         }

//         log.info("Creados {} vínculos productos-categorías", linksCreated);
//     }

//     private void createOrders(
//             List<StoreModel> stores,
//             List<PresalesModel> presalesList,
//             List<DistributorModel> distributors,
//             List<ProductModel> products,
//             int count) {

//         OrderModel.OrderStatus[] statuses = OrderModel.OrderStatus.values();

//         for (int i = 0; i < count; i++) {

//             OrderModel order = new OrderModel();
//             order.setIva_percent(19.0);
//             order.setStatus(statuses[random.nextInt(statuses.length)]);
//             order.setStore(stores.get(random.nextInt(stores.size())));

//             if (random.nextDouble() < 0.7 && !presalesList.isEmpty()) {
//                 order.setPresales(presalesList.get(random.nextInt(presalesList.size())));
//             }

//             DistributorModel distributor = distributors.get(random.nextInt(distributors.size()));
//             order.setDistributorId(distributor.getId());

//             List<OrderDetailsModel> orderDetails = new ArrayList<>();
//             Set<ProductModel> selectedProducts = new HashSet<>();

//             int numProducts = random.nextInt(4) + 2;
//             double total = 0.0;

//             while (selectedProducts.size() < numProducts && selectedProducts.size() < products.size()) {
//                 selectedProducts.add(products.get(random.nextInt(products.size())));
//             }

//             for (ProductModel product : selectedProducts) {

//                 // asegurar persistencia del producto
//                 if (product.getId() == null) {
//                     product = productRepository.save(product);
//                 }

//                 OrderDetaildEmbeddedModel detailId = new OrderDetaildEmbeddedModel();
//                 detailId.setProductId(product.getId());

//                 OrderDetailsModel detail = new OrderDetailsModel();
//                 detail.setId(detailId);
//                 detail.setProduct(product);
//                 detail.setQuantity(random.nextInt(10) + 1);
//                 detail.setUnitPrice(product.getPrice());
//                 detail.setOrder(order);

//                 total += detail.getQuantity() * detail.getUnitPrice();
//                 orderDetails.add(detail);
//             }

//             order.setTotal(total * (1 + order.getIva_percent() / 100));
//             order.setOrderDetails(orderDetails);

//             orderRepository.save(order);
//         }
//     }

//     // Métodos auxiliares
//     private DirectionDto createRandomDirection() {
//         return new DirectionDto(
//                 faker.address().streetAddress(),
//                 faker.address().city(),
//                 faker.address().streetName());
//     }

//     private DocumentTypeEnum getRandomDocumentType() {
//         DocumentTypeEnum[] types = DocumentTypeEnum.values();
//         return types[random.nextInt(types.length)];
//     }

//     private StoreClaimStatus getRandomClaimStatus() {
//         StoreClaimStatus[] statuses = StoreClaimStatus.values();
//         return statuses[random.nextInt(statuses.length)];
//     }
// }
