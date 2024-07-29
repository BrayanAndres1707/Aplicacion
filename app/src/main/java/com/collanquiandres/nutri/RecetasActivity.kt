package com.collanquiandres.nutri

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecetasActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecetasAdapter
    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recetas)

        recyclerView = findViewById(R.id.recyclerViewRecetas)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Sample data
        val recetas = listOf(
            Receta("Pollo picante con cuscús", "4", 284, 50, 22, 3, "https://static.thcdn.com/images/v2/app/uploads/sites/450/2020/01/Pollo-picante-con-cusc%C3%BAs_1578482471.jpg?width=700",
                "Ingredientes:\n\n" + "· 1 cucharada de pasta de curry\n\n" +
                        "· 1 cucharada de chutney de mango\n\n" +
                        "· ½ cucharadita de cúrcuma\n\n" +
                        "· Sal al gusto\n\n" +
                        "· 50 ml de aceite de oliva\n\n" +
                        "· 4 pechugas de pollo\n\n" +
                        "· 300 g de cuscús\n\n" +
                        "· 350 ml de caldo de verduras", "Preparación:\n\n" + "1. Primero, vierte la pasta de curry, la salsa picante, la cúrcuma, la sal y el aceite en un bol para preparar el marinado para el pollo y mezcla bien todos los ingredientes.\n\n" +
                        "2. Corta las pechugas por la mitad y rebózalas bien por el marinado hasta que queden bien cubiertas por ambos lados. Déjalas marinar durante al menos 20 minutos, aunque lo ideal es dejarlas toda la noche en la nevera.\n\n" +
                        "3. A continuación, calienta una sartén a fuego medio y vierte los trozos de pollo. Cocínalos durante unos 5-6 minutos por cada lado, o hasta que empiecen a dorarse.\n\n" +
                        "4. Mientras se cocina el pollo, pon el cuscús en un bol grande y vierte con cuidado el caldo de verduras hirviendo. Tapa el bol con un plato y déjalo a remojo durante unos 5 minutos. Pasados los 5 minutos, remueve el cuscús para que no se apelmace y añade los toppings que más te gusten. Las semillas de granada son perfectas para añadir un toque de color y sabor a la receta.\n\n" +
                        "5. Por último, reparte el cuscús en cuatro tuppers, añade dos trozos de pollo marinado en cada tupper y remata con un poco de cilantro por encima."),

            Receta("Estofado de pollo", "4", 359, 37, 29, 13, "https://static.thcdn.com/images/v2/app/uploads/sites/450/2019/11/estofado_1573724392.jpg?width=700",
                "Ingredientes:\n\n" + "2 cucharadas de aceite de coco\n\n" +
                        "· 3 pechugas de pollo\n\n" +
                        "· 2 zanahorias (en rodajas)\n\n" +
                        "· 1 apio (picado)\n\n" +
                        "· 1 cucharada de harina\n\n" +
                        "· 2 dientes de ajo (picados)\n\n" +
                        "· 700 ml de caldo de pollo\n\n" +
                        "· 500 g de patatas baby (cortadas por la mitad)\n\n" +
                        "· 1 cucharadita de tomillo\n\n" +
                        "· 1 cucharadita de sal\n\n" +
                        "· 1 cucharadita de pimienta\n\n" +
                        "· Un puñado de perejil picado", "Preparación:\n\n " + "1. Primero, pon a calentar una olla a fuego medio y derrite el aceite de coco.\n\n" +
                        "2. Añade las pechugas de pollo y deja que se cocinen durante unos minutos por cada lado hasta que se vuelvan de color blanco (en lugar del típico color rosa). Este paso sirve para que la carne retenga la humedad antes de añadirla al resto del estofado.\n\n" +
                        "3. Saca las pechugas de pollo y déjalas apartadas en un plato por ahora. Añade las zanahorias, el apio, el ajo y la harina y remueve bien para mezclar las verduras con la harina.\n\n" +
                        "4. Añade las patatas baby, el caldo de pollo, el tomillo y salpimienta al gusto. Vuelve a remover la mezcla y añade de nuevo las pechugas de pollo a la olla.\n\n" +
                        "5. Tapa la olla con su tapa y deja hervir a fuego lento durante 15 minutos.\n\n" +
                        "6. Vuelve a sacar las pechugas de pollo y desmenúzalas en un plato con la ayuda de dos tenedores.\n\n" +
                        "7. Vierte el pollo desmenuzado de nuevo a la olla, añade el perejil picado y remueve bien.\n\n" +
                        "8. Por último, sirve en un plato para disfrutarlo en el momento o guárdalo en tuppers para disfrutar de un delicioso y ligero estofado de pollo durante la semana."),

            Receta("Ensalada Thai low carb de pollo y noodles", "4", 390, 26, 139, 26, "https://static.thcdn.com/images/v2/wp-content/uploads/sites/450/2018/10/03105726/ensalada-thai-low-carb.jpg?width=700",
                "Ingredientes:\n\n" + "2 pechugas de pollo\n\n" +
                        "· 1 cucharadita de aceite de coco\n\n" +
                        "· ½ col verde rallada\n\n" +
                        "· ½ col morada rallada\n\n" +
                        "· 50 g de zanahoria rallada\n\n" +
                        "· ½ manojo de cilantro (hojas y tallos)\n\n" +
                        "· ½ manojo de cebolletas\n\n" +
                        "· 150 g de habas de soja/edamame\n\n" +
                        "· 75 g de anacardos\n\n" +
                        "· 400 g de Noodles Zero (tallarines bajos en hidratos de carbono)", "Preparación:\n " + "1. Primero, pon a calentar una sartén antiadherente a fuego medio alto y añade una cucharadita de aceite de coco.\n\n" +
                        "2. Filetea las pechugas de pollo sobre una tabla de cortar. Utiliza un cuchillo largo y afilado para cortar la pechuga por la mitad, pero sin llegar a cortarla del todo para que quede de una pieza. Haz lo mismo con la otra pechuga.\n\n" +
                        "3. Asa el pollo entre tres y cuatro minutos por cada lado, o hasta que esté cocinado a tu gusto. Una vez cocinado, déjalo apartado en un plato hasta que lo vayas a añadir a la ensalada.\n\n" +
                        "4. Sin retirar la sartén del fuego, añade ahora los anacardos. Muévelos constantemente hasta que se doren y tuesten, aproximadamente unos 7-8 minutos. Deja que se enfríen cuando estén hechos.\n\n" +
                        "5. Mientras tanto, prepara las verduras. Corta las coles retirando la parte inferior del tallo y las hojas más superficiales. Corta la col en cuatro partes y luego en tiras. Pela y ralla las zanahorias, corta las cebolletas en cortadas de 1 cm (quitando las puntas) y corta las hojas y tallos del cilantro en trozos pequeños, con cuidado de no aplastarlos.\n\n" +
                        "6. Ahora prepara los noodles. Escurre el agua de la bolsa y lávalos con agua fría. Caliéntalos en la sartén durante 2-3 minutos o en el microondas durante un minuto.\n\n" +
                        "7. A continuación, mezcla todos los ingredientes del aliño en un recipiente hasta que estén bien unificados.\n\n" +
                        "8. Ahora, mezcla todos los ingredientes de la ensalada en un bol grande, incluyendo los noodles. Añade el aliño y sirve."),

            Receta("Pasta cremosa con pollo cajún", "5", 516, 38, 71, 8, "https://static.thcdn.com/images/v2/app/uploads/sites/450/2021/04/FEATURE0326-THG0021212-MYP-NF-PASTA-1800-x-672-min_1619626601_1619693626.jpg?width=700",
                "Ingredientes:\n\n " + "· 1 cucharada de aceite de oliva\n\n" +
                        "· 1 cebolla morada (picada)\n\n" +
                        "· 200 g de champiñones (laminados)\n\n" +
                        "· 1 pimiento rojo (cortado)\n\n" +
                        "· 500 g de pechuga de pollo (troceada)\n\n" +
                        "· 1 cucharada de condimento cajún\n\n" +
                        "· Sal al gusto\n\n" +
                        "· 500 g de pasta\n\n" +
                        "· 500 ml de caldo de pollo\n\n" +
                        "· 100 g de queso fresco ligero\n\n" +
                        "· Cebollino picado para decorar", "Preparación:\n\n" + "1. Primero, calienta el aceite de oliva en una sartén grande antiadherente. Añade la cebolla, los champiñones y las tiras de pimiento y cocina durante unos minutos hasta que se pochen. Retira de la sartén y reserva para más tarde.\n\n" +
                        "2. Añade un poco más de aceite de oliva a la sartén si es necesario y añade los trozos de pollo. Cocina el pollo hasta que pierda el color rosado y añade las verduras con el condimento cajún y sal al gusto. Remueve bien para combinar todos los ingredientes.\n\n" +
                        "3. A continuación, añade la pasta y el caldo de pollo, tapa la olla y deja que se cocine a fuego lento durante 15 minutos.\n\n" +
                        "4. Pasados los 15 minutos, añade el queso crema y remueve para hacer una salsa espesa y cremosa.\n\n" +
                        "5. Sirve en platos con un poco de cebollino picado para decorar o espera que se enfríe y guárdalo en tuppers para toda la semana."),

            Receta("Rollitos de pollo rellenos", "2", 576, 58, 56, 14, "https://static.thcdn.com/images/v2/app/uploads/sites/450/2021/09/0819-STDCRE20835-MYP-TL-Kitchen_Recipes_Amends-Shot_1578_1200x672_1632475979.jpg?width=700",
                "Ingredientes:\n\n " + "2 pechugas de pollo grandes\n\n" +
                        "· 1 cucharadita de cebolla en polvo\n\n" +
                        "· 2 cucharaditas de hierbas mixtas\n\n" +
                        "· Sal y pimienta al gusto\n\n" +
                        "· 6-8 tomates secos\n\n" +
                        "· 60 g de queso cheddar bajo en grasa (rallado)\n\n" +
                        "· 200 g de espinacas tiernas\n\n" +
                        "· 100 g de pan rallado dorado\n\n" +
                        "· Spray de cocina bajo en calorías", "Preparación:\n\n " + "1. Primero precalienta el horno a 200°C.\n\n" +
                        "2. Corta las pechugas de pollo por la mitad pero sin llegar a separar las dos mitades para que se queden unidas por el centro. Cubre las pechugas con film transparente y amásalas con un rodillo para aplanarlas.\n\n" +
                        "3. Sazona al gusto con cebolla en polvo, hierbas mixtas, sal y pimienta, y añade los ingredientes como si fuera una pizza: tomates secos, espinacas tiernas y una generosa cantidad de queso cheddar.\n\n" +
                        "4. Enrolla las pechugas de pollo en horizontal con mucho cuidado para hacer los dos rollitos grandes. Clava unos palillos a lo largo de los rollitos para que no se desmonten.\n" +
                        "5. Reboza los rollitos de pollo con el pan rallado dorado, rocía con un poco de spray de cocina bajo en calorías y ponlos en una bandeja de horno cubierta con papel de hornear. Hornea durante 35 minutos o hasta que estén bien cocinados.\n\n" +
                        "6. Una vez sacados el horno, espera a que se enfríen para que puedas manipularlos, retira los palillos y corta cada rollo en rollitos más pequeños.\n\n" +
                        "7. Sirve los rollitos con una ensalada o con tus verduras favoritas, o si quieres una comida más completa, sírvelos con unos trozos de boniato."),

            Receta("Paella de pollo y chorizo", "5", 404, 31, 52, 7, "https://static.thcdn.com/images/v2/app/uploads/sites/450/2021/09/0806-STDCRE-19499-CC-MYP-Kitchen-Recipes-Shot-5-1200x672-min_1630924585.jpg?width=700",
                "Ingredientes:\n\n " + "100 g de chorizo\n\n" +
                        "· 500 g de muslos de pollo sin piel\n\n" +
                        "· Sal y pimienta al gusto\n\n" +
                        "· 1 cebolla (picada)\n\n" +
                        "· 1 cucharadita de cúrcuma\n\n" +
                        "· 1 cucharadita de pimentón\n\n" +
                        "· 2 dientes de ajo (picados)\n\n" +
                        "· 1 pimiento rojo (en rodajas)\n\n" +
                        "· 225 g de arroz para paella\n\n" +
                        "· 400 ml de caldo de pollo\n\n" +
                        "· 4 tomates (picados)\n\n" +
                        "· 100 g de guisantes", "Preparación:\n\n " + "1. Primero, añade los trozos de chorizo a una sartén antiadherente grande y cocínalos durante unos minutos hasta que empiecen a dorarse y suelten aceite. Pasados unos minutos, retíralos de la sartén y resérvalos para más tarde.\n\n" +
                        "2. Añade los muslos de pollo a la sartén y cocínalos con los aceites naturales del chorizo. Salpimienta al gusto y sigue cocinando hasta que los muslos estén bien dorados y pierdan el color rosado por dentro. Una vez cocinados, retíralos de la sartén y resérvalos también para más tarde\n\n" +
                        "3. A continuación, añade la cebolla picada y cocínala durante unos minutos hasta que se poche. Añade ahora la cúrcuma, el pimentón, el ajo y el pimiento rojo y remueve bien para que se combinen todos los ingredientes.\n\n" +
                        "4. Pasados un par de minutos, añade el arroz y remueve. A continuación, vierte el caldo de pollo y los tomates picados y vuelve a remover bien para combinar todos los ingredientes.\n\n" +
                        "5. Añade ahora los trozos de chorizo a la sartén y remueve, y después añade los muslos de pollo por encima. Tapa la sartén con su tapa y cocina a fuego lento durante 15 minutos para que el arroz se cocine y absorba el líquido.\n\n" +
                        "6. Por último, añade los guisantes, remueve de nuevo toda la mezcla y deja que se cocinen durante unos minutos antes de retirar la paella del fuego.\n\n" +
                        "7. Sirve en platos con unos gajos de lima y limón y un poco de perejil fresco."),

            Receta("Burritos de pollo saludables", "4", 378, 30, 35, 8, "https://static.thcdn.com/images/v2/app/uploads/sites/450/2022/02/FEATURE-Chicken-Burrito-Bowl_MP_KITCHENRECIPESQ4_SHOT9-min1_1643735522_1645181688.jpg?width=700",
                "Ingredientes:\n\n " + "1 cucharada de aceite de oliva\n\n" +
                        "· 1 cebolla (picada)\n\n" +
                        "· 2 dientes de ajo (machacados)\n\n" +
                        "· 2 pechugas de pollo (troceadas)\n\n" +
                        "· 1 pizca de sal\n\n" +
                        "· 1 pizca de pimienta\n\n" +
                        "· 1 cucharadita de pimentón\n\n" +
                        "· 2 botes de alubias negras (escurridas)\n\n" +
                        "· 1 bote de salsa\n\n" +
                        "· 200 g de arroz integral (50 g por ración)\n\n" +
                        "· Opcional: Gajos de lima y cilantro fresco (para adornar)", "1. Preparación:\n " + "1. Calentar el aceite de oliva en una sartén grande antiadherente y añadir la cebolla. Freír durante unos minutos para que se ablande y añadir el ajo machacado.\n\n" +
                        "2. Añadir el pollo troceado a la sartén, sazonar con sal, pimienta y pimentón, y remover bien. Cocinar durante 5-10 minutos hasta que el pollo esté completamente cocido y pase de color rosa a blanco.\n\n" +
                        "3. A continuación, añadir las alubias negras escurridas y la salsa, removiendo bien para que se integren con el resto de ingredientes. Seguir cocinando durante unos minutos y, por último, servir en platos o repartir entre cuatro tuppers para disfrutar estos deliciosos burritos de pollo en plato durante toda la semana. No te olvides de adornar con cilantro fresco y un trozo de lima."),

            Receta("Pollo al pesto con verduras", "4", 523, 52, 36, 16, "https://static.thcdn.com/images/v2/app/uploads/sites/450/2022/01/FEATURE-Pesto-Chicken-Veg_MP_KITCHENRECIPESQ4_SHOT5-min1_1642693034_1643373364.jpg?width=700",
                "Ingredientes:\n\n " + "1 cucharada de aceite de oliva\n\n" +
                        "· 4 pechugas de pollo (troceadas)\n\n" +
                        "· ½ cucharadita de sal\n\n" +
                        "· ½ cucharadita de pimienta\n\n" +
                        "· 1 cebolla roja (troceada)\n\n" +
                        "· 1 calabacín (en rodajas)\n\n" +
                        "· 400 g de judías verdes\n\n" +
                        "· 100 g de pesto bajo en grasa\n\n" +
                        "· Opcional: quinoa hervida", "Preparación:\n\n " + "1. Calienta el aceite de oliva en una sartén grande y añade la pechuga de pollo troceada. Salpimienta y cocina durante 5-7 minutos hasta que el pollo esté completamente cocido y cambie de color rosado a blanco.\n\n" +
                        "2. Añade las verduras troceadas, remueve y sigue cocinando hasta que empiecen a ablandarse. Intenta no cocinar demasiado las verduras, sobre todo si vas a preparar más cantidad para toda la semana, porque tendrás que recalentarlas cada vez que vayas a comerlas.\n\n" +
                        "3. Echa el pesto bajo en grasa a la sartén y vuelve a remover para que se integre con el resto de ingredientes, sigue cocinando durante un minuto más y apaga el fuego.\n\n" +
                        "4. Reparte el contenido de la sartén en cuatro tuppers y, en el caso de que quieras que la receta sea todavía más completa y nutritiva, añade un poco de quinoa hervida a cada tupper."),

            Receta("Nuggets de pollo saludables", "4", 272, 36, 28, 4, "https://static.thcdn.com/images/v2/app/uploads/sites/450/2020/05/Healthy-Chicken-Nuggets_1589794382.jpg?width=700",
                "Ingredientes:\n\n " + "5 cucharadas de harina\n" +
                        "· 1 cucharada de pimentón ahumado\n\n" +
                        "· 1 cucharada de pimienta negra\n\n" +
                        "· 1 cucharada de sal\n\n" +
                        "· 100 g de pan rallado\n\n" +
                        "· 2 huevos (batidos)\n\n" +
                        "· 2 pechugas de pollo\n\n" +
                        "· Spray de cocina bajo en calorías\n\n" +
                        "· Salsa Sin Azúcar (Barbacoa o Chile Dulce)", "Preparación:\n\n " + "1. Primero, precalienta el horno a 200° C.\n\n" +
                        "2. Empezaremos preparando el rebozado para los nuggets. Para ello prepararemos un plato llano con la mezcla de la harina, el pimentón, la pimienta y la sal. En un plato hondo batimos los dos huevos y en otro plato llano echaremos el pan rallado.\n\n" +
                        "3. El siguiente paso es preparar las pechugas de pollo, cortándolas en trozos pequeños. Con la ayuda de unas pinzas de cocina o un tenedor en su defecto, coge cada trozo y pásalo por la harina, luego por el huevo y luego por el pan rallado.\n\n" +
                        "4. Pon los nuggets de pollo en una bandeja de horno previamente forrada con papel de hornear y rocía un poco de aceite en spray bajo en calorías. Mete la bandeja en el horno y hornea durante 25 minutos.\n\n" +
                        "5. Una vez horneados, ya puedes disfrutarlos como prefieras. Puedes dipear con nuestras Salsas sin Azúcares sabor Barbacoa o Chile Dulce, o puedes convertirlos en una comida completa haciendo unos burritos. Todo lo que necesitarás será una tortilla wrap, un puñado de hojas de ensalada, unas rodajas de tomate y un generoso chorro de nuestra Salsa Sin Azúcar."),

            Receta("Pollo al limón con un toque de tomillo", "6", 227, 21, 5, 14, "https://static.thcdn.com/images/v2/app/uploads/sites/450/2021/08/0423-STDCRE-12981-MYP-NF-Kitchen-Recipe-Shoot-Q2-lemon-thyme-chicken1200x672-min_1627993366.jpg?width=700",
                "Ingredientes:\n\n " + "2 cucharaditas de tomillo fresco\n\n" +
                        "· 2 cucharaditas de mix de hierbas\n\n" +
                        "· Sal y pimienta al gusto\n\n" +
                        "· 6 muslos de pollo deshuesados y sin piel\n\n" +
                        "· 1 cucharada de aceite\n\n" +
                        "· 1 cebolla (picada)\n\n" +
                        "· 2 dientes de ajo (picados)\n\n" +
                        "· Zumo de 1 limón\n\n" +
                        "· 100 ml de caldo de pollo\n\n" +
                        "· 200 ml de crema agria\n\n" +
                        "· Rodajas de limón\n\n" +
                        "· Tomillo fresco", "Preparación:\n\n " + "1. Primero, se prepara el condimento para la carne. Mezcla el tomillo fresco, las hierbas mixtas, la sal y la pimienta en un bol pequeño y espolvorea la mezcla sobre los muslos de pollo. Guarda lo que sobre para más tarde.\n\n" +
                        "2. A continuación, añade el aceite a una sartén grande a fuego medio. Una vez caliente, añade los muslos de pollo y cocínalos durante varios minutos por cada lado. El pollo debe quedar crujiente y dorado por fuera y bien hecho por dentro. Una vez hecho, quítalo de la sartén y déjalo a un lado para después.\n\n" +
                        "3. En la misma sartén en la que has cocinado el pollo, añade la cebolla y el ajo y cocínalos durante unos minutos hasta que se ablanden. A continuación, añade el zumo de limón, el caldo de pollo y el resto de la mezcla de hierbas, remueve bien para mezclarlos y deja que hierva durante unos minutos.\n\n" +
                        "4. Añade la crema agria, remueve y sigue cocinando durante 2-3 minutos más para que espese. A continuación, añade los muslos de pollo a la sartén y deja que se calienten durante unos minutos.\n\n" +
                        "5. Aparta la sartén del fuego y decora con unas rodajas de limón fresco y una pizca de tomillo. Sírvelo en platos con un poco de quinoa para comerlo en el momento o guárdalo en tuppers para tener comidas para toda la semana."),

            Receta("Batido de Proteínas", "1", 180, 20, 10, 5, "https://example.com/batido_proteinas.jpg", "Ingredientes del Batido de Proteínas...", "Preparación del Batido de Proteínas...")
        )

        adapter = RecetasAdapter(recetas, this)
        recyclerView.adapter = adapter

        fab = findViewById(R.id.fab)
        fab.setOnClickListener {
            val selectedRecetas = adapter.getSelectedRecetas()
            val intent = Intent(this, ResumenRecetasActivity::class.java).apply {
                putParcelableArrayListExtra("selectedRecetas", ArrayList(selectedRecetas))
            }
            startActivity(intent)
        }
    }
}
