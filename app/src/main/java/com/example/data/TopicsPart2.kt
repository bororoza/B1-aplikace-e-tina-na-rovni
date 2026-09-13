package com.example.data

val topicsPart2: List<Topic> = listOf(
    Topic(
        id = "svatky",
        title = "Slavení svátků – pro a proti",
        icon = "🎁",
        category = "Společnost & Tradice",
        text = listOf(
            "Slavení svátků, jako jsou Vánoce, Velikonoce nebo narozeniny, je běžnou součástí našeho života. Pro mnoho lidí jsou svátky důležité a těší se na ně, jiní je ale považují za zbytečné nebo stresující. Podívejme se na výhody a nevýhody slavení svátků.",
            "Na jedné straně jsou svátky krásnou tradicí. Vánoce jsou časem, kdy se rodina setkává, společně jí a dává si dárky. Pro děti jsou svátky plné radosti a kouzelné atmosféry. Velikonoce jsou spojené s jarem, novým začátkem a tradičními zvyky, například zdobením vajíček. Narozeniny jsou výjimečný den, kdy slavíme sami sebe a dostáváme přání a dárky od svých blízkých.",
            "Další výhodou svátků je odpočinek a zpomalení každodenního života. Během svátků máme často volno z práce nebo školy, můžeme relaxovat, dobře se najíst a trávit čas s rodinou a přáteli. Svátky nám pomáhají zapomenout na stres a povinnosti.",
            "Na druhé straně mohou být svátky také náročné. Především Vánoce jsou často spojeny s velkým stresem – nakupování dárků, vaření, úklid a finanční výdaje. Pro někoho mohou být nepříjemné i některé tradice, například velikonoční pomlázka. Narozeniny mohou být smutné pro lidi, kteří jsou sami nebo nemají rádi pozornost a připomínání věku.",
            "Závěrem můžeme říct, že slavení svátků má své výhody i nevýhody. Záleží na každém člověku, jak svátky prožívá. Pro někoho jsou zdrojem radosti, pro jiného spíše stresem."
        ),
        syntacticConstructions = listOf(
            "Předložka s akuzativem: těšit se na svátky, zapomenout na stres",
            "Časové věty: časem, kdy se rodina setkává"
        ),
        lexicalPhrases = listOf(
            "Vánoce, Velikonoce, pomlázka, tradice",
            "finanční výdaje, nákupní horečka, zpomalení života"
        ),
        recommendations = "Ideální pro nácvik popisu tradic, emocí (stres, radost) a rodinného setkávání.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Svátky v životě.", listOf("Vánoce, narozeniny", "Běžná součást", "Výhody a nevýhody", "Zdroj radosti i stresu")),
            AssociationNode("2. Tradice", "🎄", "Krásné momenty.", listOf("Setkávání rodiny", "Dárky a radost dětí", "Zdobení vajíček (Velikonoce)", "Oslava narozenin")),
            AssociationNode("3. Výhody", "🛌", "Zpomalení.", listOf("Zpomalení života", "Volno v práci / škole", "Společný čas", "Zapomenout na stres")),
            AssociationNode("4. Nevýhody", "💸", "Stres a výdaje.", listOf("Finanční výdaje", "Nákupní horečka / úklid", "Osamělost o svátcích", "Nepříjemné tradice (pomlázka)"))
        ),
        examCards = listOf(
            ExamCard("Jaké jsou hlavní zvyky spojené s Vánocemi v České republice?", "Vánoce", listOf("dárky", "kapr a salát", "stromeček")),
            ExamCard("V čem spočívá negativní stránka předvánočního období?", "Stres", listOf("velký stres", "finanční výdaje", "nakupování dárků")),
            ExamCard("Jak pomáhají svátky rodinným vztahům?", "Rodina", listOf("setkávání", "společný čas", "přátelé")),
            ExamCard("Jaký je váš nejoblíbenější svátek a jak ho slavíte?", "Osobní", listOf("můj nejoblíbenější...", "vaříme...", "slavíme s rodinou"), "Popište své typické slavnostní menu.")
        )
    ),
    Topic(
        id = "nakupovani",
        title = "Nákup v obchodě nebo na internetu – pro a proti",
        icon = "🛒",
        category = "Moderní svět & Život",
        text = listOf(
            "Nakupování je běžnou součástí našeho každodenního života. Dnes máme dvě hlavní možnosti – nakupovat v kamenném obchodě nebo na internetu. Každý způsob má své výhody i nevýhody. Podívejme se na ně blíže.",
            "Na jedné straně je nakupování v kamenném obchodě velmi praktické. Zboží si můžeme prohlédnout, osahat a často i vyzkoušet. To je důležité hlavně u oblečení nebo bot. Velkou výhodou je také osobní kontakt s prodavačem, který nám může poradit. Když si něco koupíme, můžeme si to hned odnést domů a nemusíme čekat na doručení.",
            "Na druhé straně je online nakupování velmi pohodlné. Nakupujeme z domova, kdykoliv během dne nebo noci. Internet nabízí široký výběr zboží a často i nižší ceny. Snadno si porovnáme různé produkty a přečteme si recenze ostatních zákazníků. Další výhodou je doručení přímo domů, což šetří čas i energii.",
            "Oba způsoby mají ale i nevýhody. Při online nákupu si zboží nemůžeme vyzkoušet a někdy neodpovídá očekávání. Vrácení zboží může být složité a trvá delší dobu. U kamenných obchodů může být problémem časová náročnost, fronty nebo menší výběr zboží.",
            "Závěrem můžeme říct, že neexistuje jeden nejlepší způsob nakupování. Záleží na situaci a osobních preferencích. Někdy je lepší jít do obchodu, jindy je praktičtější nakoupit online."
        ),
        syntacticConstructions = listOf(
            "Adverbia času: kdykoliv během dne nebo noci",
            "Předložka u s genitivem: u kamenných obchodů, u oblečení"
        ),
        lexicalPhrases = listOf(
            "kamenný obchod, online nakupování, doručení, recenze",
            "vyzkoušet si oblečení, vrácení zboží, šetřit čas"
        ),
        recommendations = "Zaměřte se na fráze 'vyzkoušet si oblečení' a 'vrácení zboží'. Užitečné pro běžné konverzační situace.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Možnosti nákupu.", listOf("Běžná součást života", "Obchod vs Internet", "Výhody a nevýhody", "Co vybrat?")),
            AssociationNode("2. Obchod", "🏬", "Osobní kontakt.", listOf("Osahat a vyzkoušet", "Osobní kontakt", "Odnést hned domů", "Fronty a čas")),
            AssociationNode("3. Internet", "💻", "Pohodlí domova.", listOf("Kdykoliv v noci", "Širší výběr", "Nižší ceny a srovnání", "Čekání na balíček")),
            AssociationNode("4. Závěr", "🎯", "Závěrečné myšlenky.", listOf("Závisí na situaci", "Zboží neodpovídá", "Složité vracení"))
        ),
        examCards = listOf(
            ExamCard("U jakého typu zboží lidé nejčastěji dávají přednost kamenným obchodům?", "Kamenné", listOf("oblečení", "boty", "vyzkoušet si")),
            ExamCard("Jaké výhody přináší nakupování na internetu starším nebo zaneprázdněným lidem?", "Internet", listOf("šetří čas", "doručení domů", "pohodlí")),
            ExamCard("S jakými riziky se můžeme setkat při nákupu na neznámých e-shopech?", "Rizika", listOf("recenze", "zboží neodpovídá", "podvod")),
            ExamCard("Jak nakupujete nejraději vy a proč?", "Osobní", listOf("já nakupuji online...", "protože...", "knihy"), "Zhodnoťte své zkušenosti s vracením balíků.")
        )
    ),
    Topic(
        id = "skola-domov",
        title = "Vzdělávání doma a ve škole – pro a proti",
        icon = "🏫",
        category = "Vzdělávání & Informace",
        text = listOf(
            "Každé dítě se musí vzdělávat. Otázkou je, jestli je lepší učit se doma, nebo ve škole. Obě možnosti mají své výhody i nevýhody.",
            "Na jedné straně je klasická škola. Škola nabízí jasný rozvrh, pravidla a strukturu. Děti se učí společně s ostatními spolužáky, pracují ve skupinách a navazují přátelství. Učitelé jsou odborníci a mají zkušenosti s výukou různých předmětů. Ve škole se děti učí nejen učivo, ale také spolupráci, disciplíně a komunikaci. Velkou výhodou je také to, že rodiče nemusí děti sami učit.",
            "Na druhé straně může být škola někdy stresující. Děti mají testy, domácí úkoly a někdy cítí tlak na dobré známky. Některé děti mají problémy se soustředěním ve třídě nebo se necítí dobře v kolektivu. Může se objevit i šikana.",
            "Domácí vzdělávání nabízí individuální přístup. Dítě se může učit vlastním tempem a rodiče mohou výuku přizpůsobit jeho potřebám. Prostředí doma je často klidnější, a proto se některé děti lépe soustředí.",
            "Nevýhodou domácího vzdělávání je ale nedostatek sociálního kontaktu s vrstevníky. Rodiče také musí mít dostatek času, energie a znalostí, aby své dítě dobře připravili.",
            "Závěrem můžeme říct, že obě možnosti mají své klady i zápory. Záleží na potřebách dítěte i rodiny. Někomu více vyhovuje škola, jinému domácí vzdělávání."
        ),
        syntacticConstructions = listOf(
            "Účelové konstrukce: aby své dítě dobře připravili",
            "Dativ s příslovcem: někomu vyhovuje škola"
        ),
        lexicalPhrases = listOf(
            "vrstevníci, šikana, individuální přístup, rozvrh, struktura",
            "tlak na známky, navazovat přátelství"
        ),
        recommendations = "Skvělé téma na procvičení školské terminologie (předměty, testy, učivo) a vyjádření sociálních potřeb.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Dvě cesty k vědění.", listOf("Povinné vzdělávání", "Doma vs ve škole", "Pro a proti", "Individuální potřeby")),
            AssociationNode("2. Klasická škola", "🏫", "Struktura a řád.", listOf("Jasný rozvrh / Učitelé", "Spolužáci / Kamarádi", "Spolupráce a disciplína", "Rodiče nemusí učit")),
            AssociationNode("3. Rizika školy", "💔", "Stresující prostředí.", listOf("Tlak na známky", "Problémy se soustředěním", "Riziko šikany", "Stres z testů")),
            AssociationNode("4. Domov", "🏠", "Vlastní tempo.", listOf("Individuální přístup", "Klidnější prostředí", "Chybí sociální kontakt", "Časová náročnost pro rodiče"))
        ),
        examCards = listOf(
            ExamCard("Jaké sociální dovednosti získávají děti v klasické škole?", "Škola", listOf("spolupráce", "komunikace", "kamarádi")),
            ExamCard("V čem spočívají hlavní výhody domácího vzdělávání?", "Doma", listOf("vlastní tempo", "klidné prostředí", "individuální")),
            ExamCard("Proč může být domácí výuka náročná pro rodiče?", "Rodiče", listOf("dostatek času", "energie a znalosti", "příprava")),
            ExamCard("Jaký typ školy byste preferovali pro své děti vy a proč?", "Osobní", listOf("já preferuji...", "klasická škola", "protože..."), "Srovnejte školství u vás a v ČR.")
        )
    ),
    Topic(
        id = "trh-supermarket",
        title = "Nakupování na trhu nebo v supermarketu – pro a proti",
        icon = "🍓",
        category = "Moderní svět & Život",
        text = listOf(
            "Nakupování je součástí našeho každodenního života. Lidé si mohou vybrat, jestli budou nakupovat na trhu, nebo v supermarketu. Obě možnosti mají své výhody i nevýhody.",
            "Na jedné straně je nakupování na trhu. Trhy často nabízejí čerstvé ovoce, zeleninu, maso a další potraviny přímo od místních farmářů. Velkou výhodou je kvalita a čerstvost produktů. Zákazníci si někdy mohou zboží ochutnat a poradit se s prodavačem. Nakupování na trhu je také příjemný zážitek – lidé si mohou popovídat a podpořit místní podnikatele. Nevýhodou může být menší výběr zboží a někdy vyšší ceny. Trhy jsou často venku, takže špatné počasí může nákup znepříjemnit.",
            "Na druhé straně supermarket nabízí pohodlí a široký sortiment. Na jednom místě najdeme potraviny, drogerii i další zboží. Můžeme snadno porovnat ceny a využít slevy. Supermarkety mají většinou dlouhou otevírací dobu a parkoviště, což je výhodné pro rodiny nebo starší lidi. Nevýhodou je, že produkty nejsou vždy tak čerstvé jako na trhu a nákup je méně osobní. Někteří lidé také říkají, že velké supermarkety škodí malým obchodům.",
            "Závěrem můžeme říct, že obě možnosti mají své klady i zápory. Záleží na tom, co je pro člověka důležitější – čerstvost a osobní přístup, nebo pohodlí a velký výběr."
        ),
        syntacticConstructions = listOf(
            "Srovnávací spojky: nejsou vždy tak čerstvé jako na trhu",
            "Předložka na s lokálem: na jednom místě, na trhu"
        ),
        lexicalPhrases = listOf(
            "místní farmáři, sortiment, drogerie, podpořit podnikatele",
            "otevírací doba, využít slevy, škodit malým obchodům"
        ),
        recommendations = "Doporučujeme zaměřit se na sloveso 'podpořit' a frázi 'na jednom místě'. Užitečné pro argumentaci u zkoušky B1.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Kde nakoupit?", listOf("Dvě možnosti", "Část života", "Výhody a nevýhody", "Osobní volba")),
            AssociationNode("2. Trhy", "🥬", "Čerstvost a zážitek.", listOf("Od místních farmářů", "Vysoká kvalita", "Podpora podnikatelů", "Menší výběr / Počasí")),
            AssociationNode("3. Supermarket", "🏬", "Rychle a pohodlně.", listOf("Široký sortiment", "Vše na jednom místě", "Slevy a ceny", "Méně osobní přístup")),
            AssociationNode("4. Závěr", "🎯", "Závěrečná myšlenka.", listOf("Klady a zápory", "Co je důležitější", "Pohodlí vs Kvalita"))
        ),
        examCards = listOf(
            ExamCard("Proč lidé vyhledávají farmářské trhy?", "Trhy", listOf("čerstvost", "podpora farmářů", "kvalita")),
            ExamCard("V čem je nákup v supermarketu pohodlnější?", "Supermarket", listOf("široký sortiment", "vše na jednom místě", "otevírací doba")),
            ExamCard("Jak velké supermarkety ovlivňují malé lokální obchody?", "Dopad", listOf("škodit", "konkurence", "ceny")),
            ExamCard("Kde nejčastěji nakupujete potraviny vy?", "Osobní", listOf("já nakupuji v...", "jednou týdně", "zeleninu na trhu"), "Uveďte konkrétní supermarket nebo trh v ČR.")
        )
    ),
    Topic(
        id = "zdroje-informaci",
        title = "Zdroje informací – výhody a nevýhody",
        icon = "📰",
        category = "Vzdělávání & Informace",
        text = listOf(
            "V dnešní době máme mnoho možností, kde získávat informace. Můžeme používat internet, knihy, noviny nebo televizi. Každý zdroj má své výhody i nevýhody.",
            "Na jedné straně je internet a sociální sítě. Jejich hlavní výhodou je rychlost a dostupnost. Informace najdeme během několika sekund a většinou zdarma. Můžeme sledovat aktuální zprávy, číst články nebo poslouchat podcasty. Nevýhodou ale je, že ne všechny informace jsou pravdivé. Na internetu se často objevují fake news a někdy je těžké poznat, které zdroje jsou spolehlivé.",
            "Dalším zdrojem jsou knihy a tištěné noviny. Výhodou je, že knihy bývají napsané odborníky a informace jsou ověřené. Tištěné noviny také často kontrolují fakta. Čtení knih navíc pomáhá lepšímu soustředění. Nevýhodou je, že informace mohou být zastaralé a knihy nebo noviny stojí peníze.",
            "Televizní zpravodajství je další možností. Výhodou je, že zprávy jsou aktuální a připravené profesionály. Můžeme vidět reportáže přímo z místa události. Nevýhodou ale může být neobjektivita některých médií, která podporují jen určitý názor.",
            "Závěrem si myslím, že je nejlepší kombinovat různé zdroje informací a vždy si informace ověřovat. Je důležité přemýšlet nad tím, co čteme nebo slyšíme."
        ),
        syntacticConstructions = listOf(
            "Předložka s instrumentálem: přemýšlet nad tím, co čteme",
            "Podmínková a vztažná souvětí: média, která podporují jen určitý názor"
        ),
        lexicalPhrases = listOf(
            "tištěné noviny, fake news, ověřené informace, podcasty",
            "zpravodajství, spolehlivé zdroje, neobjektivita"
        ),
        recommendations = "Dobré téma pro procvičení pojmů 'pravdivé informace' vs 'lži/fake news' a kritického myšlení.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Svět informací.", listOf("Internet, knihy, TV", "Mnoho možností", "Výhody a nevýhody", "Kde hledat?")),
            AssociationNode("2. Internet", "🌐", "Rychlost a rizika.", listOf("Rychlost a dostupnost", "Podcasty a zprávy", "Zkreslené informace", "Riziko fake news")),
            AssociationNode("3. Knihy & Tisk", "📚", "Ověřená fakta.", listOf("Napsáno odborníky", "Ověřené zdroje", "Zastaralé informace", "Finanční náklady")),
            AssociationNode("4. Závěr", "🎯", "Metodický přístup.", listOf("Kombinovat zdroje", "Ověřovat informace", "Přemýšlet kriticky"))
        ),
        examCards = listOf(
            ExamCard("Jaké jsou hlavní nevýhody získávání informací ze sociálních sítí?", "Sociální sítě", listOf("fake news", "nepravdivé", "neověřené")),
            ExamCard("Proč mají tištěné knihy stále svou hodnotu?", "Knihy", listOf("odborníci", "ověřená fakta", "soustředění")),
            ExamCard("Co znamená pojem 'fake news'?", "Dezinformace", listOf("lži", "internet", "manipulace")),
            ExamCard("Odkud čerpáte denní zprávy vy osobně?", "Osobní", listOf("čtu online noviny...", "poslouchám podcasty", "televize"), "Uveďte své důvěryhodné weby.")
        )
    ),
    Topic(
        id = "kulturni-akce",
        title = "Jaké kulturní akce navštěvuji – pro a proti",
        icon = "🎭",
        category = "Společnost & Tradice",
        text = listOf(
            "Rád navštěvuji různé kulturní akce, protože mi přinášejí radost a nové zážitky. Nejčastěji chodím na koncerty, do divadla a občas také na filmové festivaly. Každý typ akce má své výhody i nevýhody.",
            "Na jedné straně kulturní akce obohacují náš život. Koncerty mají skvělou atmosféru a energie živé hudby je úplně jiná než doma z reproduktoru. Divadlo mě často nutí přemýšlet o různých tématech a rozvíjí mou fantazii. Filmové festivaly jsou zajímavé, protože nabízejí originální filmy, které běžně v kině neuvidíme. Další výhodou je, že se tam můžeme setkat s přáteli nebo poznat nové lidi se stejnými zájmy.",
            "Na druhé straně mají kulturní akce i své nevýhody. Vstupenky bývají drahé, zejména na populární koncerty nebo premiéry. Někdy jsou akce přeplněné a není dostatek místa k sezení. Také se může stát, že program nesplní naše očekávání a odcházíme zklamaní.",
            "Závěrem si myslím, že kulturní akce stojí za to navštěvovat. Přinášejí nové zkušenosti, pomáhají nám relaxovat a rozšiřují naše obzory. Je ale dobré si vybírat podle svých zájmů a možností."
        ),
        syntacticConstructions = listOf(
            "Ustálená vazba: stát za to + infinitiv (stojí za to navštěvovat)",
            "Vztažné věty: filmy, které běžně v kině neuvidíme"
        ),
        lexicalPhrases = listOf(
            "filmové festivaly, rozvíjet fantazii, rozšiřovat obzory",
            "nesplnit očekávání, živá hudba, premiéra"
        ),
        recommendations = "Doporučujeme procvičit fráze jako 'stojí za to', 'nesplnit očekávání' a vyjádření nadšení.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Kultura v životě.", listOf("Radost a zážitky", "Koncerty, divadlo, kino", "Výhody a nevýhody", "Co navštěvuji")),
            AssociationNode("2. Výhody", "🌟", "Rozvoj osobnosti.", listOf("Obohacení života", "Živá atmosféra", "Rozvoj fantazie", "Setkání s lidmi")),
            AssociationNode("3. Nevýhody", "💸", "Překážky.", listOf("Drahé vstupenky", "Přeplněné sály", "Zklamání z programu", "Nedostatek místa")),
            AssociationNode("4. Závěr", "🎯", "Doporučení.", listOf("Stojí za to navštěvovat", "Nové zkušenosti", "Rozšiřování obzorů"))
        ),
        examCards = listOf(
            ExamCard("V čem je atmosféra živého koncertu lepší než poslech hudby doma?", "Koncert", listOf("energie", "skvělá atmosféra", "reproduktor")),
            ExamCard("Proč může být divadlo náročnějším typem kultury než kino?", "Divadlo", listOf("přemýšlet o tématech", "rozvíjet fantazii")),
            ExamCard("Proč si někteří lidé stěžují na vysoké ceny vstupenek?", "Peníze", listOf("populární koncerty", "drahé vstupenky", "premiéry")),
            ExamCard("Jakou poslední kulturní akci jste navštívil/a vy?", "Osobní", listOf("minulý týden jsem byl...", "v divadle", "bylo to skvělé"), "Popište představení či koncert.")
        )
    ),
    Topic(
        id = "studium-jazyku",
        title = "Studium cizích jazyků – výhody a nevýhody",
        icon = "🗣️",
        category = "Vzdělávání & Informace",
        text = listOf(
            "Dnes je znalost cizích jazyků velmi důležitá. Svět je propojený a lidé často cestují, pracují nebo studují v zahraničí. Učit se cizí jazyk ale není vždy jednoduché. Podívejme se na výhody a nevýhody.",
            "Na jedné straně nám cizí jazyk pomáhá komunikovat s lidmi z jiných zemí. Díky tomu můžeme snadněji cestovat a poznávat nové kultury. Znalost jazyků je také velkou výhodou při hledání práce. Mnoho zaměstnavatelů požaduje alespoň jeden cizí jazyk. Další výhodou je, že učení jazyků rozvíjí paměť a zlepšuje koncentraci. Můžeme také sledovat filmy, číst knihy nebo poslouchat hudbu v originále, což je zajímavější než překlad.",
            "Na druhé straně je studium jazyků náročné a vyžaduje hodně času. Některé jazyky mají složitou gramatiku nebo těžkou výslovnost. Člověk musí pravidelně procvičovat, jinak jazyk zapomene. Problémem může být i motivace, protože výsledky nejsou vidět hned.",
            "Závěrem si myslím, že studium cizích jazyků má více výhod než nevýhod. Otevírá nové možnosti v práci i v osobním životě. Důležitá je trpělivost a pravidelnost."
        ),
        syntacticConstructions = listOf(
            "Předložková vazba: v originále, výhoda při hledání práce",
            "Podmínkové souvětí se zápornou spojkou: jinak jazyk zapomene"
        ),
        lexicalPhrases = listOf(
            "složitá gramatika, výslovnost, překlad, trpělivost",
            "výsledky nejsou vidět hned, rozvíjet paměť"
        ),
        recommendations = "Skvělé téma na propojení se samotnou zkouškou z češtiny. Procvičte slova 'trpělivost' a 'pravidelnost'.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Důležitost jazyků.", listOf("Propojený svět", "Práce, studium, cesty", "Není to jednoduché", "Pro a proti")),
            AssociationNode("2. Výhody", "🌍", "Nové obzory.", listOf("Komunikace s lidmi", "Lepší práce", "Rozvoj paměti", "Originální knihy a filmy")),
            AssociationNode("3. Nevýhody", "⏳", "Překážky při studiu.", listOf("Náročné na čas", "Složitá gramatika", "Riziko zapomínání", "Chybějící motivace")),
            AssociationNode("4. Závěr", "🎯", "Klíč k úspěchu.", listOf("Více výhod", "Nové možnosti", "Trpělivost a pravidelnost"))
        ),
        examCards = listOf(
            ExamCard("Jak vám studium češtiny pomáhá v každodenním životě v ČR?", "Čeština", listOf("hledání práce", "komunikovat", "úřady")),
            ExamCard("Proč je při studiu jazyka důležitá pravidelnost?", "Pravidelnost", listOf("jinak jazyk zapomene", "pravidelně procvičovat")),
            ExamCard("S jakými největšími problémy se potýkáte při studiu gramatiky?", "Gramatika", listOf("složitá gramatika", "výslovnost", "pádové koncovky")),
            ExamCard("Kolik cizích jazyků celkem ovládáte?", "Osobní", listOf("mluvím...", "moje mateřština je...", "anglicky"), "Uveďte svou úroveň a motivaci.")
        )
    ),
    Topic(
        id = "podnikani-zamestnani",
        title = "Podnikat nebo být zaměstnancem?",
        icon = "💼",
        category = "Práce & Společnost",
        text = listOf(
            "Každý člověk se musí rozhodnout, jestli chce podnikat, nebo být zaměstnancem. Obě možnosti mají své výhody i nevýhody.",
            "Na jedné straně je zaměstnání spojené se stabilitou. Zaměstnanec má pravidelný plat, pevnou pracovní dobu a nárok na dovolenou. Zaměstnavatel za něj platí zdravotní a sociální pojištění. Člověk se nemusí starat o daně ani hledat zákazníky. To přináší jistotu a méně stresu. Nevýhodou ale je, že zaměstnanec musí poslouchat svého šéfa a nemůže si vždy organizovat práci podle sebe. Plat bývá omezený a kariérní postup někdy pomalý.",
            "Na druhé straně podnikání nabízí větší svobodu. Podnikatel si může sám rozhodovat o pracovní době i o tom, jak bude pracovat. Může mít vyšší příjem než zaměstnanec. Na druhou stranu nese velkou odpovědnost. Musí platit daně, starat se o účetnictví a hledat zákazníky. Pokud se mu nedaří, může přijít o peníze a nemá jistý příjem.",
            "Závěrem si myslím, že záleží na povaze člověka. Někdo preferuje jistotu a stabilitu, jiný chce svobodu a je ochotný riskovat. Důležité je vybrat si cestu, která nám vyhovuje nejlépe."
        ),
        syntacticConstructions = listOf(
            "Předložková vazba: nárok na dovolenou, platit za někoho",
            "Přísudková spojení: nést velkou odpovědnost, mít jistý příjem"
        ),
        lexicalPhrases = listOf(
            "zdravotní a sociální pojištění, daně, účetnictví, kariérní postup",
            "hledat zákazníky, být ochotný riskovat"
        ),
        recommendations = "Pomáhá studentovi naučit se argumentovat na téma práce, pojištění a daní v ČR (což je praktická B1 znalost).",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Pracovní cesta.", listOf("Podnikání vs zaměstnání", "Zásadní rozhodnutí", "Výhody a nevýhody", "Osobní povaha")),
            AssociationNode("2. Zaměstnanec", "🏢", "Jistota a řád.", listOf("Pravidelný plat / pojištění", "Nárok na dovolenou", "Nemusí řešit daně", "Musí poslouchat šéfa")),
            AssociationNode("3. Podnikatel", "🚀", "Svoboda a risk.", listOf("Vlastní pracovní doba", "Vyšší možný příjem", "Velká odpovědnost", "Nemá jistý příjem")),
            AssociationNode("4. Závěr", "🎯", "Osobní postoj.", listOf("Záleží na povaze", "Někdo má rád stabilitu", "Jiný riskuje a chce svobodu"))
        ),
        examCards = listOf(
            ExamCard("Jaké výhody má zaměstnanec z hlediska sociálních jistot?", "Zaměstnanec", listOf("pravidelný plat", "dovolená", "pojištění")),
            ExamCard("S jakými administrativními překážkami se musí potýkat začínající podnikatel?", "Podnikání", listOf("daně", "účetnictví", "zákazníci")),
            ExamCard("Proč lidé někdy odcházejí ze zaměstnání na volnou nohu?", "Svoboda", listOf("organizovat si práci", "svoboda", "šéf")),
            ExamCard("Čemu byste dal/a přednost vy osobně a proč?", "Osobní", listOf("já raději zaměstnání...", "protože jistota", "chtěl bych podnikat"), "Vysvětlete své kariérní plány.")
        )
    ),
    Topic(
        id = "kniha-internet",
        title = "Kniha nebo internet – pro a proti",
        icon = "📖",
        category = "Vzdělávání & Informace",
        text = listOf(
            "V dnešní době lidé stále častěji používají internet místo klasických knih. Obě možnosti mají své výhody i nevýhody a záleží na tom, k čemu je používáme.",
            "Na jedné straně jsou knihy. Čtení knih má zvláštní atmosféru – držíme knihu v ruce, cítíme papír a můžeme se plně soustředit na text. Knihy neunavují oči tolik jako obrazovky mobilu nebo počítače. Čtení knih také rozvíjí slovní zásobu, fantazii a pomáhá zlepšovat jazyk. Velkou výhodou je, že nás při čtení knihy nic neruší – nejsou tam reklamy ani upozornění.",
            "Na druhé straně mají knihy i nevýhody. Jsou těžké a zabírají hodně místa. Když cestujeme, je praktičtější vzít si telefon nebo tablet. Knihy mohou být také drahé, zatímco na internetu najdeme mnoho informací zdarma.",
            "Internet je velmi rychlý a dostupný. Stačí pár kliknutí a máme informace o téměř jakémkoli tématu. Můžeme číst články, sledovat videa, poslouchat podcasty nebo audioknihy. Internet je také skvělý pro komunikaci s lidmi a sdílení názorů.",
            "Nevýhodou internetu je ale to, že ne všechny informace jsou pravdivé. Někdy je těžké poznat, co je správné. Internet nás také často rozptyluje – reklamy, sociální sítě nebo zprávy nám brání v soustředění.",
            "Závěrem můžeme říct, že knihy i internet mají své místo. Knihy jsou lepší pro klidné a hlubší čtení, internet je ideální pro rychlé informace. Nejlepší je používat obojí podle situace."
        ),
        syntacticConstructions = listOf(
            "Vazba s předložkou k: záleží na tom, k čemu je používáme",
            "Srovnávací konstrukce: neunavují tolik jako obrazovky"
        ),
        lexicalPhrases = listOf(
            "cítit papír, rozvíjet slovní zásobu, obrazovky mobilu",
            "rozptylovat pozornost, bránit v soustředění"
        ),
        recommendations = "Zaměřte se na výrazy 'soustředit se na' a porovnávání výhod hlubokého čtení s rychlým internetem.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Knihy vs Internet.", listOf("Změna zvyků", "Obě možnosti mají výhody", "Záleží na účelu")),
            AssociationNode("2. Knihy", "📚", "Hloubka a atmosféra.", listOf("Cítit papír", "Rozvoj slovní zásoby", "Bez reklam a rušení", "Těžké a drahé")),
            AssociationNode("3. Internet", "🌐", "Rychlost a šíře.", listOf("Dostupnost informací", "Články, podcasty, videa", "Riziko nepravdivých zpráv", "Rozptylování a nesoustředěnost")),
            AssociationNode("4. Závěr", "🎯", "Rovnováha.", listOf("Knihy pro klid", "Internet pro rychlost", "Používat obojí dle situace"))
        ),
        examCards = listOf(
            ExamCard("Jaké jsou hlavní výhody čtení papírových knih?", "Knihy", listOf("zvláštní atmosféra", "rozvíjet slovní zásobu", "nic nás neruší")),
            ExamCard("Proč lidé na cestách dávají přednost internetu a tabletům?", "Cestování", listOf("praktičtější", "nezabírají místo", "vše na jednom místě")),
            ExamCard("Jaká rizika přináší vyhledávání informací na internetu?", "Rizika", listOf("nepravdivé informace", "fake news", "reklamy a rozptylování")),
            ExamCard("Čtete raději papírové knihy, nebo používáte e-čtečky a internet?", "Váš názor", listOf("já raději...", "cítit papír", "pohodlné"), "Uveďte název naposledy přečtené knihy.")
        )
    ),
    Topic(
        id = "technologie-gadgety",
        title = "Moderní technologie a gadgety",
        icon = "📱",
        category = "Moderní svět & Život",
        text = listOf(
            "Dnes jsou moderní technologie součástí našeho každodenního života. Používáme různé gadgety, které nám pomáhají v práci, ve škole i ve volném čase. Díky technologiím je náš život jednodušší, rychlejší a pohodlnější.",
            "Nejdůležitějším zařízením pro mě je mobilní telefon. Používám ho každý den ke komunikaci s rodinou a přáteli, k psaní zpráv a telefonování. Také ho využívám pro sociální sítě, poslech hudby, sledování videí nebo čtení zpráv. Mobilní telefon je velmi praktický, protože ho mám vždy u sebe.",
            "Dalším důležitým gadgetem je notebook. Používám ho hlavně ke studiu a práci. Píšu na něm dokumenty, vyhledávám informace na internetu a účastním se online kurzů. Notebook používám i pro zábavu, například ke sledování filmů nebo hraní her.",
            "Často také používám sluchátka. Díky nim mohu poslouchat hudbu nebo podcasty a neruším ostatní lidi kolem sebe. Bezdrátová sluchátka jsou velmi pohodlná, hlavně při cestování nebo sportu.",
            "Občas používám i chytré hodinky. Ty mi pomáhají sledovat čas, počet kroků nebo zprávy. Jsou užitečné hlavně při sportu a každodenních aktivitách.",
            "Závěrem bych řekl(a), že gadgety jsou velmi užitečné a usnadňují nám život. Je ale důležité používat technologie s rozumem a trávit čas i bez obrazovek."
        ),
        syntacticConstructions = listOf(
            "Předložka díky s dativem: díky technologiím, díky nim",
            "Předložka k s dativním substantivizovaným slovesem: k psaní zpráv, k telefonování"
        ),
        lexicalPhrases = listOf(
            "gadgety, bezdrátová sluchátka, chytré hodinky, obrazovky",
            "usnadňovat život, používat s rozumem, účastnit se online kurzů"
        ),
        recommendations = "Trénujte s cizinci vyjádření 'používat s rozumem' a popis jejich nejdůležitějšího technologického zařízení.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Technologie.", listOf("Součást života", "Pomoc v práci / škole", "Jednodušší a rychlejší život")),
            AssociationNode("2. Telefon & Notebook", "💻", "Práce i zábava.", listOf("Mobil vždy u sebe", "Sociální sítě / komunikace", "Notebook na dokumenty", "Online kurzy / filmy")),
            AssociationNode("3. Sluchátka & Hodinky", "🎧", "Doplňky.", listOf("Nerušit ostatní", "Bezdrátové pohodlí", "Sledování kroků / času", "Užitečné při sportu")),
            AssociationNode("4. Závěr", "🎯", "Rovnováha.", listOf("Gadgety jsou užitečné", "Používat s rozumem", "Trávit čas bez obrazovek"))
        ),
        examCards = listOf(
            ExamCard("Který gadget je pro vás nejdůležitější a proč?", "Priorita", listOf("mobilní telefon", "vždy u sebe", "komunikace")),
            ExamCard("Jak vám notebook nebo počítač pomáhá při studiu jazyků?", "Vzdělávání", listOf("online kurzy", "vyhledávat informace", "dokumenty")),
            ExamCard("Proč je podle vás nebezpečné trávit u obrazovek příliš mnoho času?", "Zdraví", listOf("únava očí", "chybí pohyb", "používat s rozumem")),
            ExamCard("Dokázal/a byste strávit celý víkend bez telefonu a internetu?", "Detox", listOf("bylo by to těžké", "čas bez obrazovek", "příroda"), "Popište, jak byste víkend strávili.")
        )
    ),
    Topic(
        id = "zvirata",
        title = "Domácí a divoká zvířata",
        icon = "🦁",
        category = "Cestování & Příroda",
        text = listOf(
            "Zvířata jsou důležitou součástí našeho světa. Někteří lidé mají zvířata doma jako mazlíčky, jiní je rádi pozorují v přírodě nebo v zoologické zahradě. Zvířata můžeme rozdělit na dvě hlavní skupiny – domácí a divoká.",
            "Domácí zvířata žijí s lidmi a jsou na ně zvyklá. Nejčastějšími domácími mazlíčky jsou psi a kočky. Psi jsou věrní, přátelští a často hlídají dům. Kočky jsou klidnější, samostatné, ale také velmi oblíbené. Někteří lidé chovají doma i menší zvířata, například morčata, králíky, rybičky nebo papoušky. Na vesnici jsou běžná hospodářská zvířata, jako krávy, prasata, slepice nebo koně. Tato zvířata dávají lidem potraviny nebo pomáhají při práci.",
            "Divoká zvířata žijí volně v přírodě – v lesích, horách, pouštích nebo savanách. Patří mezi ně například lišky, jeleni, vlci nebo medvědi. V jiných částech světa žijí lvi, sloni, tygři nebo žirafy. Divoká zvířata nejsou zvyklá na lidi a mohou být nebezpečná. Proto je lepší je pozorovat z dálky nebo v zoologické zahradě.",
            "Dnes je mnoho divokých zvířat ohrožených. Lidé ničí jejich přirozené prostředí, loví je nebo znečišťují přírodu. Proto je velmi důležité zvířata chránit a chovat se k nim s respektem.",
            "Závěrem můžeme říct, že zvířata hrají v našem životě velkou roli. Pomáhají lidem, dělají nám radost a připomínají nám, že musíme chránit přírodu kolem sebe."
        ),
        syntacticConstructions = listOf(
            "Předložky se zvratnými tvary: zvyklá na lidi, chovat se k nim s respektem",
            "Předložka z s genitivem: pozorovat z dálky"
        ),
        lexicalPhrases = listOf(
            "hospodářská zvířata, mazlíčci, ohrožené druhy",
            "přirozené prostředí, věrný pes, chovat zvíře"
        ),
        recommendations = "Procvičujte rozdíly mezi 'chovat zvíře (doma)' a 'žít volně'. Zdůrazněte téma ochrany přírody.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Svět zvířat.", listOf("Součást našeho světa", "Domácí mazlíčci vs divočina", "Dvě hlavní skupiny")),
            AssociationNode("2. Domácí", "🐶", "Život s lidmi.", listOf("Psi a kočky (věrnost)", "Menší zvířata v klecích", "Hospodářská zvířata (venkov)", "Potraviny a pomoc")),
            AssociationNode("3. Divoká", "🌲", "Volná příroda.", listOf("Lesy, hory, savany", "Medvědi, vlci, lvi", "Nejsou zvyklá na lidi", "Nebezpečí pro člověka")),
            AssociationNode("4. Závěr", "🎯", "Ochrana.", listOf("Ohrožená zvířata", "Ničení prostředí", "Respekt a ochrana přírody"))
        ),
        examCards = listOf(
            ExamCard("Jaké výhody přináší lidem chov domácího mazlíčka?", "Mazlíčci", listOf("dělají radost", "věrný pes", "nebýt sám")),
            ExamCard("V čem se liší život zvířat na vesnici a v bytě?", "Prostředí", listOf("hospodářská zvířata", "krávy a slepice", "potraviny")),
            ExamCard("Proč jsou dnes některá divoká zvířata v přírodě ohrožená?", "Ekologie", listOf("ničit prostředí", "znečištění", "chránit přírodu")),
            ExamCard("Máte doma nějaké zvíře, nebo byste ho chtěl/a mít?", "Osobní", listOf("mám kočku...", "chtěl bych psa", "nemám čas se starat"), "Uveďte jeho jméno a péči o něj.")
        )
    ),
    Topic(
        id = "moda",
        title = "Móda dnes – ležérní × oficiální styl",
        icon = "👔",
        category = "Moderní svět & Život",
        text = listOf(
            "Móda je důležitou součástí našeho života. Oblečení ukazuje naši osobnost a také situaci, ve které se nacházíme. Dnes lidé často volí mezi ležérním a oficiálním stylem. Oba mají své výhody i nevýhody.",
            "Na jedné straně je ležérní styl velmi pohodlný. Lidé nosí džíny, trička, mikiny nebo tenisky. Tento styl je populární hlavně mezi mladými lidmi. Je vhodný do školy, na procházku nebo na setkání s přáteli. Výhodou je pohodlí a volnost. Nevýhodou ale může být, že nepůsobí vždy profesionálně, například při pracovním pohovoru.",
            "Na druhé straně je oficiální styl elegantní a reprezentativní. Patří sem oblek, košile, šaty nebo lodičky. Tento styl se hodí do práce, na svatbu nebo na důležitou schůzku. Výhodou je, že člověk působí seriózně a upraveně. Nevýhodou může být menší pohodlí a vyšší cena oblečení.",
            "Dnes se tyto styly často kombinují. Například někdo nosí elegantní sako k džínům nebo tenisky k šatům. Móda je dnes flexibilní a každý si může vybrat styl, který mu vyhovuje.",
            "Závěrem si myslím, že je důležité oblékat se podle situace. Pohodlí je důležité, ale někdy je potřeba zvolit oficiální styl."
        ),
        syntacticConstructions = listOf(
            "Předložka k s dativem: nosit sako k džínům, tenisky k šatům",
            "Předložka podle s genitivem: oblékat se podle situace"
        ),
        lexicalPhrases = listOf(
            "ležérní styl, oficiální styl, reprezentativní, flexibilní",
            "působit seriózně, pracovní pohovor, lodičky, oblek"
        ),
        recommendations = "Ideální téma na procvičení kusů oblečení (sako, košile, mikina) a frází pro vyjádření prvního dojmu.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Móda a styl.", listOf("Ukazuje osobnost", "Móda podle situace", "Ležérní vs Oficiální")),
            AssociationNode("2. Ležérní", "👟", "Volnost a džíny.", listOf("Trička, mikiny, tenisky", "Pohodlí a volnost", "Škola a přátelé", "Nepůsobí profesionálně")),
            AssociationNode("3. Oficiální", "👔", "Elegance a reprezentace.", listOf("Oblek, košile, šaty", "Svatby a schůzky", "Působí seriózně", "Méně pohodlné / drahé")),
            AssociationNode("4. Závěr", "🎯", "Kombinace.", listOf("Sako k džínům", "Móda je flexibilní", "Oblékat se podle situace"))
        ),
        examCards = listOf(
            ExamCard("Kam se podle vás nehodí ležérní styl oblečení?", "Hranice", listOf("pracovní pohovor", "svatba", "nepůsobí profesionálně")),
            ExamCard("Proč lidé nosí oficiální oblečení i přesto, že je méně pohodlné?", "Elegance", listOf("působit seriózně", "reprezentativní", "důležitá schůzka")),
            ExamCard("Jak se mění móda mladých lidí v porovnání s minulostí?", "Generace", listOf("kombinovat styly", "tenisky k šatům", "flexibilní")),
            ExamCard("Jaký styl oblečení preferujete vy v běžný den a proč?", "Osobní", listOf("já nejraději nosím...", "džíny a tričko", "pohodlí"), "Popište svůj oblíbený outfit.")
        )
    ),
    Topic(
        id = "overturismus",
        title = "Overturismus – pro a proti",
        icon = "📸",
        category = "Cestování & Příroda",
        text = listOf(
            "Overturismus znamená, že do jednoho místa přijíždí příliš mnoho turistů. Tento problém se týká hlavně velkých měst a populárních destinací, například Benátek, Barcelony nebo Prahy. Cestování je dnes dostupnější než dříve, a proto počet turistů stále roste.",
            "Na jedné straně má turismus mnoho výhod. Přináší peníze do místní ekonomiky. Turisté utrácejí za hotely, restaurace, dopravu a suvenýry. Díky tomu vznikají nová pracovní místa. Města také investují více do infrastruktury, například do oprav památek nebo lepší dopravy.",
            "Na druhé straně má overturismus i negativní dopady. V centrech měst je příliš mnoho lidí, což způsobuje hluk a znečištění. Ceny nájmů a služeb rostou, takže místní obyvatelé si někdy nemohou dovolit bydlet ve svém městě. Turisté také mohou ničit památky a přírodu. Například historické budovy nebo národní parky trpí velkým množstvím návštěvníků.",
            "Řešením může být omezení počtu turistů, vyšší turistické poplatky nebo podpora méně známých míst. Důležité je najít rovnováhu mezi turismem a ochranou života místních lidí.",
            "Závěrem si myslím, že cestování je důležité, ale mělo by být odpovědné. Turisté by měli respektovat místní kulturu a přírodu."
        ),
        syntacticConstructions = listOf(
            "Předložková vazba s genitivem: týká se velkých měst",
            "Dopady na + akuzativ: negativní dopady na životní prostředí"
        ),
        lexicalPhrases = listOf(
            "místní ekonomika, infrastruktura, ceny nájmů, poplatky",
            "odpovědné cestování, trpět množstvím návštěvníků"
        ),
        recommendations = "Ideální pro studenty žijící v Praze. Pomozte jim formulovat názory na růst cen a přeplněnost centra města.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Fenomén cestování.", listOf("Příliš mnoho turistů", "Praha, Barcelona, Benátky", "Dostupnější cestování")),
            AssociationNode("2. Výhody", "💰", "Ekonomický růst.", listOf("Peníze do ekonomiky", "Nová pracovní místa", "Investice do oprav památek", "Lepší doprava")),
            AssociationNode("3. Nevýhody", "⚠️", "Negativní dopady.", listOf("Znečištění a hluk", "Růst cen nájmů", "Místní se stěhují pryč", "Ničení památek a přírody")),
            AssociationNode("4. Závěr", "🎯", "Řešení.", listOf("Omezení počtu / poplatky", "Najít zdravou rovnováhu", "Odpovědné cestování"))
        ),
        examCards = listOf(
            ExamCard("Jaké jsou hlavní výhody turismu pro ekonomiku měst?", "Ekonomika", listOf("přináší peníze", "pracovní místa", "investice")),
            ExamCard("Proč si místní lidé v centrech turistických měst stěžují na kvalitu života?", "Stížnosti", listOf("hluk a znečištění", "ceny nájmů rostou", "přeplněné ulice")),
            ExamCard("Jaká opatření mohou města zavést proti overturismu?", "Řešení", listOf("turistické poplatky", "omezení počtu", "méně známá místa")),
            ExamCard("Vnímáte overturismus v místě, kde bydlíte vy?", "Osobní", listOf("v Praze ano...", "místní obyvatelé", "v mém městě ne"), "Vyjádřete se k situaci v centru Prahy.")
        )
    ),
    Topic(
        id = "cestovka-vlastni-pest",
        title = "Cestovka nebo na vlastní pěst",
        icon = "🗺️",
        category = "Cestování & Příroda",
        text = listOf(
            "Cestování je oblíbená činnost a každý si vybírá, jak cestovat. Někteří lidé dávají přednost cestám s cestovní kanceláří, jiní raději cestují samostatně, na vlastní pěst. Obě možnosti mají své výhody a nevýhody.",
            "Cestování s cestovní kanceláří je pohodlné. Vše je naplánované – ubytování, doprava, program výletů a prohlídek. Nemusíme se starat o letenky, vstupenky ani rezervace. Cestovní kanceláře často nabízejí průvodce, který nám vysvětluje zajímavosti a pomáhá, pokud nastanou problémy.",
            "Nevýhodou je menší svoboda. Program je pevně daný a nemůžeme měnit trasu podle vlastních přání. Cestování s cestovkou je také často dražší než individuální cesta a někdy se setkáme s velkým počtem turistů.",
            "Cestování na vlastní pěst nabízí svobodu a flexibilitu. Sami si plánujeme trasu, ubytování a aktivity. Můžeme se zastavit tam, kde chceme, a zůstat déle na zajímavých místech. Často je to levnější než cestování s cestovkou.",
            "Nevýhodou je, že všechno musíme plánovat sami. Je potřeba sledovat letenky, ubytování a dopravu. Pokud nastanou problémy, musíme je řešit sami. Některé destinace mohou být složité pro cizince, kteří neznají jazyk nebo místní zvyky.",
            "Každá forma cestování má své plusy i mínusy. Pokud chceme pohodlí i organizaci, je lepší cestovat s cestovní kanceláří. Pokud chceme svobodu a dobrodružství, vyplatí se cestovat na vlastní pěst. Ideální je kombinace – například část cesty s cestovkou a část individuálně."
        ),
        syntacticConstructions = listOf(
            "Idiom s akuzativem: cestovat na vlastní pěst",
            "Podmínkové věty s pokud: pokud nastanou problémy, musíme..."
        ),
        lexicalPhrases = listOf(
            "cestovní kancelář, průvodce, individuální cesta",
            "starat se o rezervace, vyplatí se, pevně daný program"
        ),
        recommendations = "Skvělé téma na procvičení plánování cesty (rezervace, letenky, ubytování).",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Styl cestování.", listOf("Oblíbená činnost", "S cestovkou vs Sám", "Výhody a nevýhody")),
            AssociationNode("2. S cestovkou", "🚌", "Pohodlí a organizace.", listOf("Naplánované ubytování", "Průvodce pomáhá", "Menší svoboda", "Často dražší")),
            AssociationNode("3. Na vlastní pěst", "🎒", "Svoboda a flexibilita.", listOf("Sami plánujeme", "Zastavit se kdekoliv", "Často levnější", "Všechno řešíme sami")),
            AssociationNode("4. Závěr", "🎯", "Shrnutí.", listOf("Pohodlí vs Dobrodružství", "Záleží na povaze", "Ideální je kombinace"))
        ),
        examCards = listOf(
            ExamCard("Jaké jsou největší výhody cestování s cestovní kanceláří?", "Cestovka", listOf("nemusíme se starat", "ubytování a doprava", "průvodce")),
            ExamCard("Proč může být individuální cestování náročné na přípravu?", "Individuální", listOf("sledovat letenky", "plánovat trasu", "řešit problémy")),
            ExamCard("V jakých situacích byste doporučil/a spíše organizovaný zájezd?", "Rada", listOf("neznámý jazyk", "složité destinace", "pohodlí")),
            ExamCard("Jak cestujete nejraději vy a proč?", "Zkušenost", listOf("na vlastní pěst", "sám si plánuji", "ušetřím peníze"), "Popište svou nejlepší samostatnou cestu.")
        )
    ),
    Topic(
        id = "rodina-velka-mala",
        title = "Velká rodina nebo malá rodina?",
        icon = "👨‍👩‍👧‍👦",
        category = "Společnost & Tradice",
        text = listOf(
            "Rodina je důležitou součástí našeho života. Každý člověk má jinou představu o ideální rodině. Někteří lidé dávají přednost velké rodině, jiní mají raději malou rodinu. Obě možnosti mají svoje výhody a nevýhody. Co je lepší?",
            "Velká rodina je ideální pro lidi, kteří mají rádi společnost a společně trávený čas. Doma je vždy někdo, s kým si můžete povídat, hrát nebo trávit volný čas. Sourozenci si mohou navzájem pomáhat a rodiče nejsou na všechno sami. Ve velké rodině bývá často veselo a děti se učí spolupracovat a dělit se o věci.",
            "Nevýhoda velké rodiny je, že potřebuje více peněz. Rodiče musí koupit více jídla, oblečení a dalších věcí. Také je někdy těžké najít čas pro každého člena rodiny a doma může být větší hluk.",
            "Malá rodina je vhodná pro lidi, kteří mají rádi klid a více soukromí. Rodiče mají více času na děti a mohou jim věnovat větší pozornost. Také mají často méně starostí a rodinné výdaje bývají nižší. V malé rodině je jednodušší plánovat dovolenou nebo společné aktivity.",
            "Nevýhoda malé rodiny je, že děti mohou být často samy. Nemají sourozence, se kterými by si hrály nebo si povídaly. Když rodiče pracují, dítě může mít pocit samoty. Také je méně lidí, kteří si mohou navzájem pomáhat.",
            "Co je lepší? Každý má jiný názor. Někteří lidé dávají přednost velké rodině, protože mají rádi společnost a společně trávený čas. Jiní mají raději malou rodinu, protože chtějí více klidu a soukromí."
        ),
        syntacticConstructions = listOf(
            "Vztažné souvětí: sourozenci, se kterými by si hrály",
            "Reciproční zvratnost: pomáhat si navzájem, dělit se o věci"
        ),
        lexicalPhrases = listOf(
            "sourozenci, jedináček, rodinné výdaje, soukromí",
            "dělit se o věci, věnovat pozornost, pocit samoty"
        ),
        recommendations = "Ideální téma na vyjádření rodinných hodnot, popisu dětství a finančních aspektů života rodiny.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Rodinné hodnoty.", listOf("Důležitá část života", "Různé představy", "Velká vs Malá rodina")),
            AssociationNode("2. Velká rodina", "👨‍👩‍👧‍👦", "Společnost a hluk.", listOf("Vždycky je s kým mluvit", "Vzájemná pomoc sourozenců", "Finančně náročné", "Méně času na jednotlivce")),
            AssociationNode("3. Malá rodina", "👨‍👩‍👦", "Klid a pozornost.", listOf("Více času rodičů", "Nižší výdaje", "Jednodušší plánování", "Pocit samoty u dětí")),
            AssociationNode("4. Závěr", "🎯", "Shrnutí názorů.", listOf("Názory se liší", "Společnost vs Klid", "Každému vyhovuje něco jiného"))
        ),
        examCards = listOf(
            ExamCard("Čemu se děti učí, když vyrůstají v rodině s více sourozenci?", "Děti", listOf("dělit se o věci", "spolupracovat", "pomáhat si")),
            ExamCard("Proč může být velká rodina finančně velmi náročná?", "Peníze", listOf("více jídla a oblečení", "vyšší výdaje", "podpora dětí")),
            ExamCard("Jaké výhody přináší jedináčkovi to, že nemá sourozence?", "Jedináček", listOf("maximální pozornost", "více času", "klid")),
            ExamCard("V jak velké rodině jste vyrostl/a vy a co se vám na tom líbilo?", "Osobní", listOf("já jsem vyrostl v...", "bylo nás pět", "měl jsem bratra"), "Zhodnoťte vztahy se svými blízkými.")
        )
    )
)
