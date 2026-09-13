package com.example.data

val topicsPart1: List<Topic> = listOf(
    Topic(
        id = "more-hory",
        title = "Moře nebo hory?",
        icon = "🏖️",
        category = "Cestování & Příroda",
        text = listOf(
            "Moře a hory jsou oblíbená místa pro dovolenou. Každé má svoje výhody a nevýhody. Co je lepší?",
            "Moře je ideální pro lidi, kteří chtějí odpočívat. Můžete ležet na pláži, poslouchat šumění vln a číst knihu. Slunce je příjemné, ale někdy může být příliš horko. Moře je také skvělé pro plavání a vodní sporty, například potápění nebo jízdu na paddleboardu. Děti si rády hrají v písku a staví hrady.",
            "Nevýhoda moře je, že na plážích bývá hodně lidí, hlavně v létě. Některé pláže jsou přeplněné a drahé. Slaná voda může být nepříjemná pro citlivou kůži. A pokud nemáte rádi vedro, možná vás moře rychle omrzí.",
            "Hory jsou vhodné pro ty, kdo mají rádi aktivní dovolenou. Můžete chodit na túry, jezdit na kole nebo objevovat krásnou přírodu. Čerstvý vzduch je zdravý a v horách najdete klid. Pokud rádi sportujete, hory nabízejí mnoho možností. V zimě tam můžete lyžovat nebo jezdit na snowboardu.",
            "Nevýhoda hor je, že musíte být v dobré kondici. Túry můžou být náročné a počasí v horách je často nevyzpytatelné – může začít pršet nebo být zima. Také hory nejsou pro všechny – lidé, kteří mají rádi teplo, tam nejsou spokojení.",
            "Co je lepší? Každý má jiný názor. Někteří lidé milují moře, jiní dávají přednost horám."
        ),
        syntacticConstructions = listOf(
            "Vztažné věty: pro lidi, kteří chtějí... / pro ty, kdo mají...",
            "Podmínková souvětí: pokud nemáte rádi..., možná vás moře omrzí"
        ),
        lexicalPhrases = listOf(
            "Verbiální substantiva: šumění vln, plavání, potápění",
            "B1 idiomy: být v dobré kondici, omrzet (koho), dávat přednost"
        ),
        recommendations = "Zaměřte se na kontrastní spojky jako 'zatímco', 'na jedné straně' a správné předložky 'u moře' vs 'v horách'.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Zahájení debaty.", listOf("Moře a hory", "Oblíbená místa", "Výhody a nevýhody", "Co je lepší?")),
            AssociationNode("2. Moře", "🏖️", "Relax, slunce a pláže.", listOf("Odpočívat na pláži", "Šumění vln", "Slaná voda / Kůže", "Přeplněné pláže")),
            AssociationNode("3. Hory", "🏔️", "Aktivita a příroda.", listOf("Aktivní dovolená", "Čerstvý vzduch", "Zimní sporty", "Nevyzpytatelné počasí")),
            AssociationNode("4. Závěr", "🎯", "Shrnutí názorů.", listOf("Každý má jiný názor", "Někdo miluje moře", "Jiný dává přednost horám"))
        ),
        examCards = listOf(
            ExamCard("Proč lidé jezdí rádi k moři a co tam obvykle dělají?", "Moře", listOf("odpočívat", "šumění vln", "vodní sporty")),
            ExamCard("Jaké aktivity se dají dělat v horách v létě a v zimě?", "Hory", listOf("chodit na túry", "čerstvý vzduch", "lyžovat")),
            ExamCard("Proč není dovolená v horách vhodná pro každého?", "Rizika", listOf("dobrá kondice", "nevyzpytatelné počasí")),
            ExamCard("Čemu dáváte přednost vy a z jakých důvodů?", "Váš názor", listOf("já raději...", "protože...", "na rozdíl od..."), "Používejte srovnávací spojky (zatímco, na rozdíl od).")
        )
    ),
    Topic(
        id = "dum-byt",
        title = "Bydlení v domě nebo v bytě?",
        icon = "🏡",
        category = "Bydlení & Domov",
        text = listOf(
            "Bydlení v domě a bydlení v bytě jsou běžné možnosti bydlení. Každé má svoje výhody a nevýhody. Co je lepší?",
            "Bydlení v domě je ideální pro lidi, kteří mají rádi prostor a klid. Můžete mít více pokojů, zahradu, garáž nebo dílnu. Můžete odpočívat na zahradě, pěstovat květiny nebo grilovat s přáteli. Velkou výhodou je také více soukromí. V domě vás obvykle neruší sousedé.",
            "Nevýhoda domu je, že cena je vyšší. Dům také potřebuje více práce. Musíte se starat o zahradu, opravovat dům a řešit různé technické problémy. To může být časově i finančně náročné.",
            "Bydlení v bytě je vhodné pro lidi, kteří chtějí jednoduchý a pohodlný život. Nemusíte se starat o velký prostor a údržbu většinou dělá správce. Byt je často levnější než dům. Výhodou je také poloha – byty se často nachází ve městě, kde máte blízko obchody, školy, restaurace a práci.",
            "Nevýhoda bytu je, že máte méně prostoru a méně soukromí. Můžete slyšet sousedy, kteří dělají hluk. Také se musíte dělit o společné prostory, například chodbu nebo výtah.",
            "Co je lepší? Každý má jiný názor. Někteří lidé mají raději dům, protože chtějí klid a soukromí, jiní dávají přednost bytu, protože chtějí bydlet ve městě a nechtějí se starat o velký prostor."
        ),
        syntacticConstructions = listOf(
            "Vztažné věty lokálové: ve městě, kde máte...",
            "Infinitivní vazby: musíte se starat / opravovat / řešit..."
        ),
        lexicalPhrases = listOf(
            "Akuzativ s předložkou: starat se o + 4. pád, dělit se o...",
            "Instrumentál: grilovat s přáteli"
        ),
        recommendations = "Procvičte se studenty sloveso 'starat se o' (pojí se se 4. pádem) a antonyma 'více soukromí' vs 'méně prostoru'.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Základní srovnání.", listOf("Bydlení v domě / bytě", "Běžné možnosti", "Každé má výhody", "Co je lepší?")),
            AssociationNode("2. Dům", "🏡", "Prostor a práce.", listOf("Více soukromí / Zahrada", "Grilovat s přáteli", "Vyšší cena", "Časově náročné")),
            AssociationNode("3. Byt", "🏢", "Město a pohodlí.", listOf("Údržbu dělá správce", "Poloha ve městě", "Méně soukromí", "Dělit se o prostory")),
            AssociationNode("4. Závěr", "🎯", "Závěrečná volba.", listOf("Každý má jiný názor", "Dům pro klid", "Byt pro město"))
        ),
        examCards = listOf(
            ExamCard("Jaké výhody přináší lidem vlastní zahrada u domu?", "Dům", listOf("odpočívat", "grilovat", "pěstovat květiny")),
            ExamCard("Proč je život v bytě pro mnoho lidí časově méně náročný?", "Byt", listOf("jednoduchý život", "údržba", "správce")),
            ExamCard("S jakými problémy se můžete setkat při soužití se sousedy v bytě?", "Nevýhody", listOf("hluk", "méně soukromí", "společné prostory")),
            ExamCard("Kde byste chtěl/a bydlet vy a proč?", "Volba", listOf("dávám přednost...", "nechtěl bych se starat...", "blízko do práce"), "Uveďte konkrétní důvody pro svůj výběr.")
        )
    ),
    Topic(
        id = "mesto-vesnice",
        title = "Bydlení ve městě nebo na vesnici?",
        icon = "🏙️",
        category = "Bydlení & Domov",
        text = listOf(
            "Bydlení ve městě a bydlení na vesnici jsou běžné možnosti. Každé má svoje výhody a nevýhody. Co je lepší?",
            "Bydlení ve městě je ideální pro lidi, kteří chtějí být blízko práce, škol a obchodů. Můžete mít dobrý přístup ke kulturním akcím, restauracím a zábavě. Veřejná doprava je rychlá a pohodlná. Město je vhodné hlavně pro mladé lidi, kteří chtějí aktivní život.",
            "Nevýhodou města je hluk a znečištěné ovzduší. Je zde hodně aut a lidí. Bydlení je často drahé a lidé někdy mají pocit anonymity – neznají své sousedy a mají málo času.",
            "Bydlení na vesnici je vhodné pro lidi, kteří mají rádi klid a přírodu. Vzduch je čistý, hluk a stres je menší. Lidé se většinou znají a mají mezi sebou lepší vztahy. Bydlení na vesnici je také často levnější.",
            "Nevýhodou vesnice je horší dostupnost služeb. Obchody, školy nebo lékaři bývají daleko. Pracovní příležitosti jsou omezené a bez auta se často neobejdete. Pro mladé lidi může být život na vesnici méně zajímavý.",
            "Co je lepší? Každý má jiný názor. Někteří lidé dávají přednost městu, protože chtějí být v centru dění a mít vše blízko. Jiní mají raději vesnici, protože chtějí klid, přírodu a lepší vztahy s lidmi."
        ),
        syntacticConstructions = listOf(
            "Předložka na: na vesnici (6. pád) vs ve: ve městě",
            "Zápor s genitivem: bez auta (2. pád) se neobejdete"
        ),
        lexicalPhrases = listOf(
            "Fráze: být v centru dění, pocit anonymity, dostupnost služeb",
            "Sloveso: neobejít se bez něčeho"
        ),
        recommendations = "Doporučujeme procvičit kontrast 'anonymita' vs 'lidé se znají'. Spojení 'neobejdete se bez' je skvělé pro úroveň B1.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Základní přehled.", listOf("Město a vesnice", "Běžné možnosti", "Výhody a nevýhody", "Co je lepší?")),
            AssociationNode("2. Město", "🏙️", "Ruch a možnosti.", listOf("Práce, školy blízko", "Kultura a zábava", "Znečištěné ovzduší", "Pocit anonymity")),
            AssociationNode("3. Vesnice", "🏡", "Klid a příroda.", listOf("Čistý vzduch", "Lepší vztahy", "Horší dostupnost", "Bez auta ne")),
            AssociationNode("4. Závěr", "🎯", "Rozdílné preference.", listOf("Centrum dění", "Klid a vztahy", "Každý má svůj názor"))
        ),
        examCards = listOf(
            ExamCard("Proč mladí lidé často preferují život ve velkém městě?", "Město", listOf("aktivní život", "dostupnost", "školy a práce")),
            ExamCard("Jaké jsou hlavní nevýhody života na venkově bez automobilu?", "Vesnice", listOf("dostupnost služeb", "lékař", "neobejít se bez")),
            ExamCard("Co znamená pojem 'anonymita velkoměsta'?", "Sociální aspekt", listOf("neznat sousedy", "málo času", "pocit")),
            ExamCard("Kde vidíte svou budoucnost vy osobně?", "Názor", listOf("já dávám přednost...", "protože...", "na druhou stranu"), "Porovnejte klady a zápory z vlastní zkušenosti.")
        )
    ),
    Topic(
        id = "cestovani-doprava",
        title = "Cestování autem, letadlem nebo vlakem?",
        icon = "✈️",
        category = "Cestování & Příroda",
        text = listOf(
            "Cestování autem, letadlem a vlakem jsou běžné způsoby dopravy. Každý z nich má svoje výhody a nevýhody. Co je lepší?",
            "Cestování autem je ideální pro lidi, kteří chtějí svobodu a flexibilitu. Můžete jet, kam chcete a kdy chcete. Nemusíte se řídit jízdním řádem a můžete si zastavit, kdykoli potřebujete – například na jídlo nebo odpočinek. Auto je vhodné pro kratší cesty a pro rodiny.",
            "Nevýhodou auta je vyšší cena. Benzín nebo nafta jsou drahé a ve městech je často problém s parkováním. Auto také není dobré pro životní prostředí a na dlouhých cestách může být řízení únavné.",
            "Cestování letadlem je vhodné pro dlouhé vzdálenosti. Je to nejrychlejší způsob dopravy a během několika hodin se můžete dostat do jiné země nebo na jiný kontinent. Letadla jsou většinou pohodlná a bezpečná.",
            "Nevýhodou letadla je vysoká cena letenek, hlavně při nákupu na poslední chvíli. Také musíte přijet na letiště včas, projít kontrolami a čekat. Někdy mají lety zpoždění, což může být stresující.",
            "Cestování vlakem je příjemné a pohodlné. Můžete se dívat na krajinu, číst, pracovat nebo odpočívat. Vlak je dobrý i pro cestování s dětmi. V České republice je vlak často levnější než auto nebo letadlo.",
            "Nevýhodou vlaku je, že vlaky někdy mají zpoždění nebo jsou přeplněné. Ne všechny vlaky jsou moderní a pohodlné. V některých zemích může být vlak také drahý.",
            "Co je lepší? Každý způsob cestování má svoje plusy i mínusy. Někteří lidé dávají přednost autu, protože chtějí flexibilitu a možnost zastavit kdykoliv. Jiní raději cestují letadlem, protože chtějí rychle dorazit na dlouhé vzdálenosti. Někteří lidé mají rádi vlak, protože je pohodlný, mohou při něm odpočívat a dívat se na krajinu."
        ),
        syntacticConstructions = listOf(
            "Instrumentál dopravy: autem, letadlem, vlakem",
            "Zájmenná příslovce: kdykoli, kamkoli, jakkoli"
        ),
        lexicalPhrases = listOf(
            "Slovní spojení: řídit se jízdním řádem, nákup na poslední chvíli",
            "Mít zpoždění, projít kontrolami"
        ),
        recommendations = "Zaměřte se na správné tvary 7. pádu u dopravních prostředků a vyjádření časové flexibility.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Způsoby dopravy.", listOf("Auto, letadlo, vlak", "Běžné způsoby", "Výhody a nevýhody", "Co je lepší?")),
            AssociationNode("2. Auto", "🚗", "Svoboda na cestách.", listOf("Flexibilita / svoboda", "Bez jízdního řádu", "Drahé palivo", "Únava z řízení")),
            AssociationNode("3. Letadlo & Vlak", "✈️", "Rychlost a relax.", listOf("Dlouhé vzdálenosti", "Vlak: pohled na krajinu", "Letadlo: drahé letenky", "Vlak: možná zpoždění")),
            AssociationNode("4. Závěr", "🎯", "Porovnání preferencí.", listOf("Každý způsob má plusy", "Někdo dává přednost autu", "Jiný letadlu / vlaku"))
        ),
        examCards = listOf(
            ExamCard("Proč lidé dávají přednost cestování vlakem v České republice?", "Vlak", listOf("levný", "pohodlný", "krajina")),
            ExamCard("S jakými problémy se můžete setkat na letišti?", "Letadlo", listOf("zpoždění", "kontrola", "čekání")),
            ExamCard("Proč není automobil ekologickou volbou?", "Ekologie", listOf("životní prostředí", "benzín", "emise")),
            ExamCard("Jak nejraději cestujete vy na dlouhé dovolené?", "Osobní", listOf("já nejraději...", "protože...", "letadlem"), "Popište svou poslední delší cestu.")
        )
    ),
    Topic(
        id = "mestska-doprava",
        title = "Cestování ve městě – veřejná doprava nebo auto?",
        icon = "🚇",
        category = "Cestování & Příroda",
        text = listOf(
            "Cestování ve městě je součástí každodenního života. Lidé mohou používat veřejnou dopravu nebo auto. Každý způsob dopravy má svoje výhody a nevýhody. Co je lepší?",
            "Veřejná doprava, jako metro, autobus nebo tramvaj, je ideální pro lidi, kteří chtějí cestovat levně a ekologicky. Můžete jet metrem, tramvají nebo autobusem a dostat se rychle do různých částí města. Metro je rychlé a není závislé na dopravních zácpách. Tramvaj je pohodlná a můžete se při jízdě dívat na město. Velkou výhodou je také, že veřejná doprava snižuje počet aut ve městě, což je dobré pro životní prostředí.",
            "Nevýhoda veřejné dopravy je, že ve špičce bývá přeplněná. Dopravní prostředky mohou být nepohodlné a cesta je někdy stresující. Někdy může dojít ke zpoždění a při přestupování může cesta trvat déle.",
            "Cestování autem je vhodné pro lidi, kteří chtějí pohodlí a flexibilitu. Můžete jet, kam chcete a kdy chcete. Nemusíte čekat na spoj a můžete si zastavit, kdykoli potřebujete. Auto je vhodné pro rodiny s dětmi nebo pro přepravu těžkých věcí.",
            "Nevýhoda auta je vysoká cena. Musíte platit za benzín, parkování a opravy. Ve městech jsou často dopravní zácpy a najít parkovací místo může být obtížné. Auto také není dobré pro životní prostředí.",
            "Co je lepší? Každý má jiný názor. Někteří lidé dávají přednost veřejné dopravě, protože je levná a ekologická. Jiní mají raději auto, protože chtějí pohodlí a flexibilitu."
        ),
        syntacticConstructions = listOf(
            "Kauzální věty: což je dobré pro...",
            "Předložka s instrumentálem: jet tramvají, cestovat autem"
        ),
        lexicalPhrases = listOf(
            "veřejná doprava, špička, dopravní zácpa, ekologický",
            "být závislý na, přestupovat na spoj"
        ),
        recommendations = "Důležité je spojení 'být závislý na' a 'dopravní zácpy'. Pomáhá popsat realitu života ve městě.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Doprava ve městě.", listOf("Součást života", "Auto vs MHD", "Výhody a nevýhody", "Co je lepší?")),
            AssociationNode("2. MHD", "🚇", "Levně a čistě.", listOf("Metro, bus, tramvaj", "Nezávislé na zácpách", "Přeplněné ve špičce", "Zpoždění a přestupy")),
            AssociationNode("3. Auto ve městě", "🚗", "Pohodlí s překážkami.", listOf("Pohodlí a flexibilita", "Těžké věci / děti", "Zácpy a parkování", "Benzín a opravy")),
            AssociationNode("4. Závěr", "🎯", "Finální srovnání.", listOf("MHD je levná", "Auto pro pohodlí", "Rozdílné názory"))
        ),
        examCards = listOf(
            ExamCard("Proč je metro často nejrychlejším způsobem dopravy ve městě?", "Metro", listOf("dopravní zácpy", "rychlé", "pod zemí")),
            ExamCard("S jakými problémy se potýkají řidiči aut ve velkých městech?", "Auta", listOf("parkování", "zácpy", "vysoká cena")),
            ExamCard("V čem spočívá ekologický přínos veřejné dopravy?", "Ekologie", listOf("méně aut", "životní prostředí", "tramvaje")),
            ExamCard("Jak se po městě pohybujete vy?", "Praxe", listOf("já jezdím tramvají", "protože...", "nemám auto"), "Vyjádřete se k pražské MHD.")
        )
    ),
    Topic(
        id = "pocasi",
        title = "Počasí – jaro, léto, podzim nebo zima?",
        icon = "🍂",
        category = "Cestování & Příroda",
        text = listOf(
            "Počasí je součástí našeho každodenního života. Ovlivňuje naši náladu, práci i volný čas. Každé roční období má svoje výhody a nevýhody. Co je lepší?",
            "Jaro je ideální pro lidi, kteří mají rádi příjemné počasí. Můžete chodit na procházky, sportovat nebo trávit čas venku. Svítí slunce, ale není velké horko. Příroda kvete a lidé mají často lepší náladu.",
            "Nevýhoda jara je, že často prší. Počasí může být nestálé a někdy je těžké plánovat venkovní aktivity. Déšť může být nepříjemný, i když je důležitý pro přírodu.",
            "Léto je vhodné pro lidi, kteří mají rádi teplo a slunce. Můžete chodit k vodě, plavat nebo jet na dovolenou. Lidé často grilují, tráví čas venku a odpočívají. Léto nabízí mnoho možností pro sport a zábavu.",
            "Nevýhoda léta je velké horko. Vysoké teploty mohou být nepříjemné při práci nebo při spánku. Vedro může být také nebezpečné pro starší lidi a malé děti.",
            "Podzim je vhodný pro lidi, kteří mají rádi klid a přírodu. Můžete chodit na procházky, jezdit na výlety nebo sbírat houby. Příroda je velmi krásná a listy mají různé barvy.",
            "Nevýhoda podzimu je déšť, vítr a kratší dny. Počasí může být chladné a někteří lidé se cítí unavení, protože je méně světla.",
            "Zima je ideální pro lidi, kteří mají rádi zimní sporty. Můžete lyžovat, bruslit nebo jet na hory. Děti si často hrají ve sněhu a staví sněhuláky. Zima má také svoji krásnou atmosféru.",
            "Nevýhoda zimy je velká zima a tma. Dny jsou krátké a silnice mohou být nebezpečné kvůli sněhu nebo ledu.",
            "Co je lepší? Každý má jiný názor. Někteří lidé mají rádi léto, protože je teplo a mohou jet na dovolenou. Jiní dávají přednost jaru nebo podzimu, protože počasí není tak horké. Někteří lidé mají rádi zimu, protože mohou sportovat na sněhu."
        ),
        syntacticConstructions = listOf(
            "Bezpodmětové věty: svítí slunce, prší, je zima, je tma",
            "Předložka pro: ideální pro lidi, nebezpečné pro děti"
        ),
        lexicalPhrases = listOf(
            "sbírat houby, stavět sněhuláky, roční období",
            "kvůli sněhu a ledu, nestálé počasí"
        ),
        recommendations = "Ideální pro procvičení názvů ročních období v různých pádech a popisu počasí.",
        associationMap = listOf(
            AssociationNode("1. Jaro & Léto", "🌸", "Teplo a květy.", listOf("Příroda kvete", "Procházky a sport", "Horko a slunce", "Dovolená u vody")),
            AssociationNode("2. Podzim & Zima", "❄️", "Klid a sníh.", listOf("Barevné listí / Houby", "Kratší dny / Únava", "Zimní sporty", "Velká zima a tma")),
            AssociationNode("3. Nevýhody", "⚠️", "Problémy s počasím.", listOf("Nestálé počasí / Déšť", "Vysoké teploty v noci", "Sníh na silnicích", "Nedostatek světla")),
            AssociationNode("4. Závěr", "🎯", "Osobní volba.", listOf("Každý má rád něco", "Léto pro dovolenou", "Jaro pro mírné teploty"))
        ),
        examCards = listOf(
            ExamCard("Jak ovlivňuje počasí lidskou náladu a zdraví?", "Nálada", listOf("únava", "světlo", "lepší nálada")),
            ExamCard("Proč může být horké letní počasí nebezpečné?", "Léto", listOf("vysoké teploty", "starší lidé", "nebezpečné")),
            ExamCard("Jaké jsou typické podzimní aktivity v České republice?", "Podzim", listOf("sbírat houby", "procházky", "výlety")),
            ExamCard("Které roční období máte nejraději vy a proč?", "Osobní", listOf("mám rád...", "protože...", "zimní sporty"), "Uveďte typické počasí ve své rodné zemi.")
        )
    ),
    Topic(
        id = "katastrofy",
        title = "Přírodní katastrofy – nebezpečí a prevence",
        icon = "🌪️",
        category = "Cestování & Příroda",
        text = listOf(
            "Přírodní katastrofy jsou nebezpečné události v přírodě. Patří mezi ně například zemětřesení, povodně, tornáda nebo požáry. Tyto události mají závažné dopady na člověka i krajinu.",
            "Přírodní katastrofy jsou nebezpečné pro lidi i pro přírodu. Mohou zničit domy, silnice nebo stromy. Například zemětřesení může způsobit pád budov. Povodně vznikají při silných deštích a voda může zaplavit města a vesnice. Tornáda a hurikány mají velmi silný vítr a ničí domy, auta a stromy.",
            "Nevýhoda přírodních katastrof je, že způsobují velké škody. Lidé mohou přijít o domov, práci nebo majetek. Tyto události mohou být také nebezpečné pro lidské životy a pro životní prostředí.",
            "Prevence a ochrana je vhodná pro lidi, kteří chtějí být připraveni na nebezpečí. Můžeme stavět pevnější domy, sledovat předpověď počasí nebo poslouchat pokyny odborníků. Existují také varovné systémy, které informují lidi o nebezpečí. Například při povodních je důležité odejít na vyvýšené místo a při zemětřesení se schovat pod stůl.",
            "Nevýhoda prevence je, že přírodní katastrofy nemůžeme úplně zastavit. Někdy mohou přijít velmi rychle a lidé nemají dost času se připravit.",
            "Co je lepší? Každý má jiný názor. Někteří lidé si myslí, že je nejdůležitější prevence a příprava. Jiní říkají, že přírodu nemůžeme úplně kontrolovat a musíme být opatrní a připravení."
        ),
        syntacticConstructions = listOf(
            "Předložka při s lokálem: při povodních, při zemětřesení",
            "Infinitivní vyjádření pokynů: odejít na vyvýšené místo, schovat se pod stůl"
        ),
        lexicalPhrases = listOf(
            "zemětřesení, povodeň, tornádo, požár, prevence",
            "způsobit škody, přijít o domov a majetek"
        ),
        recommendations = "Trénujte se studenty vyjadřování rad a pokynů (např. 'při povodních je důležité...').",
        associationMap = listOf(
            AssociationNode("1. Typy hrozeb", "🌋", "Různé katastrofy.", listOf("Zemětřesení / Požáry", "Povodně / Deště", "Tornáda / Hurikány", "Zničení domů")),
            AssociationNode("2. Škody", "🏚️", "Následky živlů.", listOf("Ztráta majetku / domova", "Pád budov", "Ohrožení životů", "Záplavy měst")),
            AssociationNode("3. Prevence", "🛡️", "Ochrana a příprava.", listOf("Pevnější domy", "Sledovat předpověď", "Varovné systémy", "Odejít na vyvýšené místo")),
            AssociationNode("4. Závěr", "🎯", "Možnosti kontroly.", listOf("Nemůžeme je zastavit", "Důležitá příprava", "Příroda má navrch"))
        ),
        examCards = listOf(
            ExamCard("Jaké škody mohou způsobit povodně ve městech?", "Povodně", listOf("zaplavit", "zničit domy", "velké škody")),
            ExamCard("Jak se lidé mohou chránit před zemětřesením?", "Prevence", listOf("schovat se pod stůl", "pevnější domy")),
            ExamCard("Proč je důležité sledovat předpověď počasí?", "Informovanost", listOf("varovné systémy", "být připraven", "tornádo")),
            ExamCard("Zažil/a jste někdy nějakou přírodní katastrofu?", "Zkušenost", listOf("naštěstí ne", "pamatuji si...", "silný déšť"), "Popište osobní zážitek nebo situaci ze zpráv.")
        )
    ),
    Topic(
        id = "zdrave-jidlo",
        title = "Zdravé jídlo nebo nezdravé jídlo?",
        icon = "🍎",
        category = "Jídlo & Životospráva",
        text = listOf(
            "Jídlo je důležitou součástí našeho života. Každý den musíme jíst, ale často řešíme otázku, jestli je lepší zdravé nebo nezdravé jídlo. Každé má svoje výhody a nevýhody. Co je lepší?",
            "Zdravé jídlo je ideální pro lidi, kteří chtějí být zdraví a mít více energie. Můžete jíst zeleninu, ovoce, ryby, celozrnné pečivo nebo ořechy. Tyto potraviny obsahují vitamíny, minerály a vlákninu, které jsou důležité pro naše tělo. Když jíme zdravě, cítíme se lépe a můžeme si udržet správnou váhu.",
            "Nevýhoda zdravého jídla je, že někdy může být dražší. Také příprava jídla může trvat déle. Některým lidem zdravé jídlo nechutná a dávají přednost jiným jídlům.",
            "Nezdravé jídlo je vhodné pro lidi, kteří chtějí rychlé a jednoduché řešení. Můžete jíst například hamburgery, hranolky, sladkosti nebo chipsy. Toto jídlo je často chutné, levné a snadno dostupné. Když nemáme čas nebo jsme unavení, je fast food jednoduchou možností.",
            "Nevýhoda nezdravého jídla je vysoký obsah cukru, tuku a soli. Když ho jíme často, můžeme přibrat na váze a mít zdravotní problémy. Také se můžeme cítit unavení a bez energie.",
            "Co je lepší? Každý má jiný názor. Někteří lidé dávají přednost zdravému jídlu, protože chtějí být zdraví a mít více energie. Jiní lidé mají rádi nezdravé jídlo, protože je rychlé a chutné. Pro mnoho lidí je nejlepší najít rovnováhu mezi zdravým a nezdravým jídlem."
        ),
        syntacticConstructions = listOf(
            "Časové a podmínkové spojky: když jíme zdravě, cítíme se lépe",
            "Předložka pro s akuzativem: důležité pro naše tělo"
        ),
        lexicalPhrases = listOf(
            "vitamíny, vláknina, cukr, tuk, sůl, váha",
            "přibrat na váze, udržet si váhu, najít rovnováhu"
        ),
        recommendations = "Doporučujeme procvičit protiklad 'mít energii' vs 'být unavený' a vyjádření zdravé rovnováhy.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Role jídla.", listOf("Důležitá součást", "Zdravé vs nezdravé", "Výhody a nevýhody", "Co je lepší?")),
            AssociationNode("2. Zdravé jídlo", "🍎", "Energie a vitamíny.", listOf("Zelenina, ovoce, ryby", "Vitamíny a vláknina", "Dražší cena", "Dlouhá příprava")),
            AssociationNode("3. Nezdravé jídlo", "🍔", "Rychlost a rizika.", listOf("Hamburgery, sladkosti", "Chutné a levné", "Vysoký obsah tuku", "Zdravotní problémy")),
            AssociationNode("4. Závěr", "🎯", "Zlatá střední cesta.", listOf("Najít rovnováhu", "Každý má jiný názor", "Záleží na životním stylu"))
        ),
        examCards = listOf(
            ExamCard("Jaké potraviny bychom měli jíst, abychom byli zdraví?", "Zdraví", listOf("ovoce a zelenina", "vitamíny", "ryby")),
            ExamCard("Proč lidé tak často jedí nezdravé jídlo (fast food)?", "Fast Food", listOf("levné", "rychlé řešení", "chutné")),
            ExamCard("Jaké zdravotní problémy může způsobit nezdravá strava?", "Rizika", listOf("přibrat na váze", "únava", "cukr a tuk")),
            ExamCard("Jak vypadá váš běžný jídelníček?", "Osobní", listOf("já se snažím...", "vařím doma", "občas jím..."), "Popište svou typickou snídani, oběd a večeři.")
        )
    ),
    Topic(
        id = "doma-restaurace",
        title = "Stravování doma nebo v restauraci?",
        icon = "🍳",
        category = "Jídlo & Životospráva",
        text = listOf(
            "Jídlo je důležitou součástí našeho života. Každý den jíme několikrát denně. Často ale řešíme otázku, jestli je lepší vařit doma, nebo jíst v restauraci. Každá možnost má svoje výhody a nevýhody. Co je lepší?",
            "Stravování doma je ideální pro lidi, kteří chtějí mít kontrolu nad jídlem. Můžete si vybrat čerstvé suroviny a vařit podle chuti. Také víte, co jíte, a domácí jídlo je často levnější než jídlo v restauraci. Vaření doma může být také příjemná aktivita s rodinou.",
            "Nevýhoda stravování doma je, že zabírá hodně času. Musíte nakoupit suroviny, vařit a mýt nádobí. Někdy lidé nemají po práci energii nebo inspiraci, co vařit.",
            "Stravování v restauraci je vhodné pro lidi, kteří chtějí pohodlí. Nemusíte vařit ani uklízet a můžete si vybrat z menu. Restaurace nabízejí různá jídla, která si doma běžně nepřipravujeme. Je to také dobrá příležitost setkat se s přáteli nebo oslavit zvláštní události.",
            "Nevýhoda restaurace je vyšší cena. Jídlo může obsahovat více soli, cukru nebo tuku. Také nemáte úplnou kontrolu nad kvalitou surovin a restaurace mohou být někdy hlučné nebo přeplněné.",
            "Co je lepší? Každý má jiný názor. Někteří lidé dávají přednost vaření doma, protože chtějí zdravé a levnější jídlo. Jiní mají raději restaurace, protože je to pohodlné a nemusí vařit. Pro mnoho lidí je nejlepší kombinace – většinou jíst doma a občas jít do restaurace."
        ),
        syntacticConstructions = listOf(
            "Konstrukce: mít kontrolu nad + Instrumentál",
            "Sloveso s předložkou: vybrat si z + Genitiv"
        ),
        lexicalPhrases = listOf(
            "čerstvé suroviny, mýt nádobí, zvláštní události",
            "zabírat čas, nemít energii po práci"
        ),
        recommendations = "Doporučujeme procvičit slovní zásobu z oblasti kuchyně (suroviny, nádobí, menu) a sociální kontakt v restauraci.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Stravování obecně.", listOf("Jíme několikrát denně", "Doma vs restaurace", "Každé má výhody", "Co vybrat?")),
            AssociationNode("2. Doma", "🍳", "Kontrola a úspora.", listOf("Čerstvé suroviny", "Levnější než venku", "Zabírá hodně času", "Mytí nádobí")),
            AssociationNode("3. Restaurace", "🍕", "Pohodlí a menu.", listOf("Nemusíte uklízet", "Setkání s přáteli", "Vyšší cena", "Nedostatek kontroly")),
            AssociationNode("4. Závěr", "🎯", "Ideální kompromis.", listOf("Většinou doma", "Občas v restauraci", "Kombinace obojího"))
        ),
        examCards = listOf(
            ExamCard("Jaké jsou hlavní výhody domácího vaření?", "Doma", listOf("čerstvé suroviny", "kontrola", "levnější")),
            ExamCard("Proč lidé navštěvují restaurace kromě samotného jídla?", "Restaurace", listOf("setkání s přáteli", "oslavy", "pohodlí")),
            ExamCard("Jaké nevýhody může mít stravování v restauracích každý den?", "Rizika", listOf("vyšší cena", "sůl a tuk", "přeplněné")),
            ExamCard("Jak často vaříte vy a co je vaše nejoblíbenější jídlo na přípravu?", "Osobní", listOf("já vařím...", "moje oblíbené jídlo...", "jednou týdně"), "Uveďte recept na své oblíbené jídlo.")
        )
    ),
    Topic(
        id = "zdravy-styl",
        title = "Zdravý životní styl – pro a proti",
        icon = "🏃",
        category = "Jídlo & Životospráva",
        text = listOf(
            "Zdravý životní styl je dnes velmi aktuální téma. Lidé se snaží jíst zdravě, pravidelně sportovat a dostatečně odpočívat. Tento způsob života má mnoho výhod, ale také některé nevýhody.",
            "Výhody zdravého životního stylu: Zdravý životní styl je dobrý pro naše tělo i psychiku. Když jíme zdravě, tělo dostává vitamíny a minerály, které potřebuje. Máme více energie a cítíme se lépe. Pravidelný pohyb, například běhání, plavání nebo cvičení, pomáhá uvolnit stres a zlepšuje náladu. Sport je důležitý pro zdravé srdce a svaly. Velmi důležitý je také odpočinek. Když dobře spíme, tělo se regeneruje a jsme méně unavení. Zdravý životní styl pomáhá dělat prevenci nemocem, jako jsou cukrovka, obezita nebo problémy se srdcem.",
            "Nevýhody zdravého životního stylu: Nevýhodou může být, že zdravý životní styl je časově i finančně náročný. Zdravé potraviny bývají dražší a příprava jídla zabírá čas. Ne každý má možnost pravidelně sportovat kvůli práci nebo rodině. Dalším problémem je, že někteří lidé to se zdravým životním stylem přehánějí. Příliš přísné diety nebo nadměrné cvičení mohou být nezdravé a nebezpečné.",
            "Závěr: Zdravý životní styl má své plusy i mínusy. Důležité je najít rovnováhu a žít tak, aby nám to vyhovovalo a cítili jsme se dobře."
        ),
        syntacticConstructions = listOf(
            "Kondicionál a infinitiv: žít tak, aby nám to vyhovovalo",
            "Předložka s instrumentálem: přehánět to se zdravým stylem"
        ),
        lexicalPhrases = listOf(
            "regenerace, prevence, cukrovka, obezita",
            "přísné diety, nadměrné cvičení, uvolnit stres"
        ),
        recommendations = "Trénujte srovnávací věty a vyjadřování přiměřenosti ('nic se nemá přehánět').",
        associationMap = listOf(
            AssociationNode("1. Výhody", "💪", "Fyzické zdraví.", listOf("Vitamíny a minerály", "Zdravé srdce / svaly", "Prevence nemocí", "Lepší spánek")),
            AssociationNode("2. Psychika", "🧠", "Duševní rovnováha.", listOf("Uvolnění stresu", "Zlepšení nálady", "Více energie", "Méně únavy")),
            AssociationNode("3. Nevýhody", "⏳", "Překážky a limity.", listOf("Časově náročné", "Dražší zdravé jídlo", "Přehánění (diety)", "Nedostatek času na sport")),
            AssociationNode("4. Závěr", "🎯", "Shrnutí.", listOf("Najít rovnováhu", "Co nám vyhovuje", "Cítit se dobře"))
        ),
        examCards = listOf(
            ExamCard("Proč je pravidelný pohyb důležitý pro naši psychiku?", "Pohyb", listOf("uvolnit stres", "zlepšuje náladu", "více energie")),
            ExamCard("Proč může být zdravý životní styl finančně náročný?", "Peníze", listOf("dražší potraviny", "fitness", "bio")),
            ExamCard("Jaká jsou rizika, když to člověk se zdravou stravou a sportem přehání?", "Rizika", listOf("přísné diety", "nadměrné cvičení", "nebezpečné")),
            ExamCard("Co děláte pro své zdraví vy osobně?", "Osobní", listOf("já se snažím spát...", "chodím pěšky", "piju vodu"), "Pojmenujte své každodenní zdravé návyky.")
        )
    ),
    Topic(
        id = "profese",
        title = "Mužské a ženské profese – pro a proti",
        icon = "👷",
        category = "Práce & Společnost",
        text = listOf(
            "V minulosti se profese často dělily na mužské a ženské. Muži pracovali například jako stavitelé, řidiči nebo vojáci. Ženy byly učitelky, zdravotní sestry nebo pracovaly v domácnosti. Dnes se tato situace mění. Otázkou je, jestli je toto rozdělení správné, nebo už není důležité.",
            "Pro rozdělení profesí: Někteří lidé si myslí, že některé profese jsou vhodnější pro muže nebo pro ženy. Například práce na stavbě je fyzicky náročná a vyžaduje sílu, proto tam častěji pracují muži. Naopak práce učitelky nebo zdravotní sestry vyžaduje trpělivost, péči a empatii, což mají ženy často přirozeně. Rozdělení profesí může být praktické, protože každý dělá práci, která mu jde nejlépe.",
            "Proti rozdělení profesí: Na druhou stranu dnes mnoho lidí s tímto rozdělením nesouhlasí. Ženy mohou být silné a pracovat jako stavitelky, vojačky nebo pilotky. Muži mohou být skvělí učitelé, zdravotní bratři nebo kadeřníci. Rozdělení profesí podle pohlaví je podle některých lidí zastaralé. Každý by měl mít možnost vybrat si práci podle svých schopností a zájmů, ne podle pohlaví.",
            "Závěr: Rozdělení profesí na mužské a ženské je dnes často diskutované téma. Někteří lidé vidí rozdíly mezi muži a ženami, jiní podporují rovnost. Důležité je, aby každý mohl dělat práci, která ho baví a naplňuje."
        ),
        syntacticConstructions = listOf(
            "Konstrukce: podle pohlaví vs podle schopností",
            "Vyjádření opozice: na druhou stranu, naopak"
        ),
        lexicalPhrases = listOf(
            "zdravotní bratr, stavitelka, pilotka",
            "vyžadovat trpělivost a empatii, rovnost příležitostí"
        ),
        recommendations = "Ideální pro diskuzi o rovnosti pohlaví a změnách v moderní společnosti.",
        associationMap = listOf(
            AssociationNode("1. Minulost", "⏳", "Tradiční rozdělení.", listOf("Muži: stavitelé, vojáci", "Ženy: učitelky, sestry", "Práce v domácnosti", "Dnes se to mění")),
            AssociationNode("2. Pro rozdělení", "⚖️", "Fyzické/povahové rysy.", listOf("Fyzická síla u mužů", "Empatie a péče u žen", "Každému jde něco lépe", "Praktické rozdělení")),
            AssociationNode("3. Proti rozdělení", "🤝", "Rovné příležitosti.", listOf("Stavitelky, pilotky", "Zdravotní bratři, kadeřníci", "Zastaralý pohled", "Podle schopností a zájmů")),
            AssociationNode("4. Závěr", "🎯", "Shrnutí diskuse.", listOf("Diskutované téma", "Podpora rovnosti", "Bavit a naplňovat"))
        ),
        examCards = listOf(
            ExamCard("Jaké profese byly v minulosti považovány za čistě ženské?", "Minulost", listOf("učitelka", "zdravotní sestra", "domácnost")),
            ExamCard("Proč lidé poukazují na fyzické rozdíly u některých profesí?", "Fyzická síla", listOf("stavba", "vyžaduje sílu", "muži")),
            ExamCard("Jak se díváte na muže v tradičně ženských profesích?", "Moderní doba", listOf("schopnosti", "naplňuje", "rovnost")),
            ExamCard("Je ve vaší zemi rozdělení profesí stále silně vnímáno?", "Kultura", listOf("u nás...", "tradiční", "moderní"), "Uveďte srovnání s Českou republikou.")
        )
    ),
    Topic(
        id = "manualni-intelektualni",
        title = "Manuální a intelektuální práce – pro a proti",
        icon = "🧠",
        category = "Práce & Společnost",
        text = listOf(
            "Manuální a intelektuální práce jsou dva různé typy práce. Každý z nich má svoje výhody a nevýhody. Záleží na tom, co člověku vyhovuje a co ho baví.",
            "Manuální práce je vhodná pro lidi, kteří rádi pracují rukama a pohybují se. Patří sem například práce na stavbě, oprava aut nebo práce na poli. Výhodou manuální práce je, že výsledky vidíme hned. Práce je často praktická a užitečná. Navíc se při ní hodně hýbeme, což je dobré pro zdraví.",
            "Nevýhodou manuální práce je fyzická náročnost. Často se pracuje venku, takže záleží na počasí. Po několika letech může být tělo unavené nebo může bolet záda a klouby.",
            "Intelektuální práce je vhodná pro lidi, kteří rádi přemýšlejí a učí se nové věci. Mezi tyto profese patří učitel, lékař nebo programátor. Výhodou je, že tato práce bývá lépe placená. Často se pracuje v kanceláři nebo z domova a nejsme závislí na počasí.",
            "Nevýhodou intelektuální práce je psychická únava. Celý den sedět u počítače nebo řešit složité problémy může být stresující. Také chybí pohyb, což není zdravé.",
            "Závěr: Manuální i intelektuální práce jsou důležité. Každý člověk by si měl vybrat práci podle svých schopností, zájmů a zdravotního stavu."
        ),
        syntacticConstructions = listOf(
            "Fráze: záleží na tom, co člověku vyhovuje",
            "Podmínkové věty s příslovcem: nejsme závislí na počasí"
        ),
        lexicalPhrases = listOf(
            "výsledky vidíme hned, sedět u počítače, psychická únava",
            "fyzická náročnost, bolet záda a klouby"
        ),
        recommendations = "Dobré téma na procvičení protikladů: 'fyzická práce/únava' vs 'psychická únava/stres'.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Dva typy práce.", listOf("Manuální vs intelektuální", "Výhody a nevýhody", "Co člověka baví")),
            AssociationNode("2. Manuální", "🛠️", "Práce rukama.", listOf("Výsledky vidíme hned", "Dobrý pohyb pro zdraví", "Fyzická náročnost", "Závislost na počasí")),
            AssociationNode("3. Intelektuální", "💻", "Práce hlavou.", listOf("Přemýšlení a učení", "Lepší finanční ohodnocení", "Psychická únava / stres", "Sedavé zaměstnání")),
            AssociationNode("4. Závěr", "🎯", "Závěrečné shrnutí.", listOf("Oba typy jsou důležité", "Záleží na schopnostech", "Zdravotní stav"))
        ),
        examCards = listOf(
            ExamCard("Jaké jsou největší výhody manuální práce?", "Manuální", listOf("vidět výsledky", "pohyb", "užitečná")),
            ExamCard("Proč může být intelektuální práce psychicky náročnější?", "Intelektuální", listOf("psychická únava", "stres", "počítač")),
            ExamCard("Jak se projevuje nedostatek pohybu u kancelářských profesí?", "Zdraví", listOf("bolest zad", "sedět celý den", "nezdravé")),
            ExamCard("Jakou práci děláte nebo byste chtěl/a dělat vy?", "Osobní", listOf("já pracuji jako...", "baví mě...", "preferuji..."), "Popište svůj běžný pracovní den.")
        )
    ),
    Topic(
        id = "konicky",
        title = "Aktivní a pasivní koníčky – co je lepší?",
        icon = "🎸",
        category = "Volný čas & Sport",
        text = listOf(
            "Každý má svůj oblíbený způsob, jak trávit volný čas. Někteří lidé mají rádi aktivní koníčky, jiní dávají přednost pasivním. Co je lepší? Podívejme se na výhody a nevýhody obou.",
            "Aktivní koníčky jsou ty, při kterých se hýbeme a zapojujeme tělo. Může to být sport, tanec, turistika nebo třeba zahradničení. Výhoda aktivních koníčků je, že udržují naše tělo zdravé a v kondici. Při sportu například zlepšujeme svou fyzickou sílu a máme více energie. Kromě toho pomáhají i naší psychice – pohyb nám dává dobrý pocit a odbourává stres. Aktivní koníčky také často znamenají sociální kontakt. Například při fotbale nebo tenisu se setkáváme s dalšími lidmi.",
            "Nevýhodou může být, že na ně někdy potřebujeme více času, peněz nebo vybavení. Například lyžování je drahé a cyklistika vyžaduje kolo a bezpečné cesty.",
            "Pasivní koníčky jsou například čtení knih, sledování filmů nebo poslech hudby. Výhodou pasivních koníčků je, že u nich můžeme relaxovat a odpočívat. Po dlouhém dni v práci nebo ve škole je skvělé sednout si s knihou nebo se podívat na oblíbený seriál. Pasivní koníčky jsou také dostupné pro každého – knihy si můžeme půjčit v knihovně a hudbu poslouchat zadarmo online.",
            "Nevýhodou ale je, že při pasivních koníčcích nevyužíváme tělo, a pokud jen sedíme, můžeme být unavení a nemáme dostatek pohybu.",
            "Každý koníček má své pro a proti. Ideální je kombinovat obojí – aktivní pohyb i odpočinek. Jaký koníček je váš oblíbený? A jak trávíte svůj volný čas?"
        ),
        syntacticConstructions = listOf(
            "Předložka při s lokálem: při pasivních koníčcích, při sportu",
            "Spojovací výrazy: kromě toho, nevýhodou ale je..."
        ),
        lexicalPhrases = listOf(
            "odbourávat stres, udržovat se v kondici, relaxovat",
            "dostupný pro každého, zapojovat tělo"
        ),
        recommendations = "Procvičujte spojení 'trávit volný čas' a 'zapojovat tělo'. Ideální pro představení zálib.",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Volný čas.", listOf("Způsob trávení času", "Aktivní vs pasivní", "Výhody obou", "Co je lepší?")),
            AssociationNode("2. Aktivní", "⚽", "Pohyb a lidé.", listOf("Turistika, sport, tanec", "Fyzická síla", "Sociální kontakt", "Čas a drahé vybavení")),
            AssociationNode("3. Pasivní", "📚", "Relax a knihy.", listOf("Čtení, filmy, hudba", "Relaxace po práci", "Dostupné pro všechny", "Chybí pohyb")),
            AssociationNode("4. Závěr", "🎯", "Ideální stav.", listOf("Kombinace obojího", "Pohyb i odpočinek", "Osobní dotaz"))
        ),
        examCards = listOf(
            ExamCard("Jak aktivní koníčky pomáhají proti stresu?", "Psychika", listOf("odbourávat stres", "pohyb", "dobrý pocit")),
            ExamCard("Proč jsou pasivní koníčky považovány za dostupné pro každého?", "Dostupnost", listOf("zadarmo online", "knihovna", "čtení")),
            ExamCard("Co se stane, když se člověk věnuje pouze pasivním zálibám?", "Rizika", listOf("málo pohybu", "únava", "nevyužívat tělo")),
            ExamCard("Jak nejraději trávíte volný čas vy?", "Osobní", listOf("já rád čtu...", "hraju fotbal", "podle nálady"), "Vysvětlete, jak dobíjíte energii po práci.")
        )
    ),
    Topic(
        id = "druhy-sportu",
        title = "Druhy sportů – pro a proti",
        icon = "🏀",
        category = "Volný čas & Sport",
        text = listOf(
            "Sport je důležitou součástí našeho života. Pomáhá nám zůstat zdraví, zlepšuje naši kondici a má také pozitivní vliv na psychiku. Existuje mnoho druhů sportů, například týmové, individuální, vodní, zimní nebo extrémní sporty. Každý z nich má své výhody i nevýhody.",
            "Týmové sporty, jako jsou fotbal, hokej nebo volejbal, jsou velmi oblíbené. Jejich hlavní výhodou je spolupráce s ostatními lidmi. Sportovci se učí komunikovat, pomáhat si a být zodpovědní za celý tým. Týmové sporty jsou také zábavné a umožňují poznat nové kamarády. Nevýhodou ale je, že ne každému vyhovuje pracovat ve skupině. Někteří lidé se cítí pod tlakem nebo jim vadí závislost na ostatních.",
            "Individuální sporty, například běh, plavání nebo jóga, jsou vhodné pro lidi, kteří mají rádi klid a nezávislost. Výhodou je, že si každý může zvolit vlastní tempo a čas. Tyto sporty pomáhají ke zklidnění a soustředění. Nevýhodou může být, že při nich chybí sociální kontakt a pro někoho mohou být méně zábavné.",
            "Vodní sporty, jako je plachtění nebo potápění, jsou zajímavé a umožňují kontakt s přírodou. Často přinášejí silné zážitky. Nevýhodou je potřeba speciálního vybavení a někdy i trenéra, což může být finančně náročné.",
            "Zimní sporty, například lyžování nebo snowboarding, jsou populární hlavně v zimě. Přinášejí radost z pohybu na sněhu, ale vyžadují drahé vybavení a ne každý má rád chladné počasí.",
            "Extrémní sporty, jako horolezectví nebo parašutismus, jsou velmi adrenalinové. Jsou vzrušující, ale také nebezpečné a drahé.",
            "Závěrem lze říct, že každý druh sportu má své klady i zápory. Nejlepší sport záleží na osobnosti, zájmech a fyzických možnostech každého člověka. Důležité je, aby nás sport bavil a prospíval našemu zdraví."
        ),
        syntacticConstructions = listOf(
            "Konstrukce s dativem: prospívat zdraví, vyhovovat někomu",
            "Předložka za: být zodpovědný za tým"
        ),
        lexicalPhrases = listOf(
            "týmové, individuální, vodní, zimní, extrémní sporty",
            "vlastní tempo, zklidnění a soustředění, adrenalinový"
        ),
        recommendations = "Ideální pro srovnávání různých sportovních kategorií a vyjádření preferencí.",
        associationMap = listOf(
            AssociationNode("1. Týmové", "⚽", "Lidé a týmy.", listOf("Fotbal, hokej, volejbal", "Spolupráce a komunikace", "Zodpovědnost za tým", "Tlak ve skupině")),
            AssociationNode("2. Individuální", "🏃", "Klid a tempo.", listOf("Běh, plavání, jóga", "Vlastní tempo", "Zklidnění", "Chybí kontakt")),
            AssociationNode("3. Ostatní", "🏂", "Voda, sníh, adrenalin.", listOf("Vodní: silné zážitky", "Zimní: na sněhu", "Extrémní: adrenalin", "Drahé vybavení / riziko")),
            AssociationNode("4. Závěr", "🎯", "Můj sport.", listOf("Záleží na osobnosti", "Fyzické možnosti", "Musí nás to bavit"))
        ),
        examCards = listOf(
            ExamCard("Čemu se lidé učí při týmových sportech?", "Tým", listOf("spolupráce", "komunikovat", "zodpovědnost")),
            ExamCard("Pro koho jsou vhodné individuální sporty?", "Klid", listOf("vlastní tempo", "nezávislost", "soustředění")),
            ExamCard("Proč jsou extrémní sporty tak populární i přes svá rizika?", "Adrenalin", listOf("vzrušující", "adrenalin", "silné zážitky")),
            ExamCard("Jaký sport provozujete vy a jak často?", "Osobní", listOf("já běhám...", "každý víkend", "v létě plavu"), "Zmiňte, jak dlouho se sportu věnujete.")
        )
    ),
    Topic(
        id = "domaci-prace",
        title = "Mužské a ženské práce v domácnosti – pro a proti",
        icon = "🧹",
        category = "Práce & Společnost",
        text = listOf(
            "Otázka mužských a ženských prací v domácnosti je dnes často diskutované téma. Někteří lidé si myslí, že určité práce jsou přirozeně mužské nebo ženské. Jiní tvrdí, že takové rozdělení už v moderní společnosti nemá místo. Podívejme se na obě strany tohoto problému.",
            "Na jedné straně existuje tradiční pohled. Podle něj muži obvykle vykonávají fyzicky náročnější práce, jako jsou opravy v domácnosti, stěhování těžkých věcí nebo práce na zahradě. Ženy se naopak častěji starají o vaření, úklid a děti. Pro některé rodiny je toto rozdělení praktické a přehledné. Každý ví, co má dělat, a může to vést k menším konfliktům v domácnosti.",
            "Na druhé straně mnoho lidí s tímto rozdělením nesouhlasí. Tvrdí, že dnes by měl každý umět zvládnout všechny domácí práce bez ohledu na pohlaví. Muž by měl umět vařit, uklízet nebo prát a žena by měla být schopná opravit drobné věci. Navíc dnes ženy často pracují stejně jako muži, a proto je spravedlivé, aby si partneři domácí práce rozdělili rovným dílem.",
            "Důležité je také říct, že každá rodina je jiná. Některé rodiny mají tradiční rozdělení rolí, jiné moderní přístup. Záleží na domluvě, osobních schopnostech a kulturních tradicích.",
            "Závěrem můžeme říct, že neexistuje jedno správné řešení. Nejlepší je takové rozdělení prací, se kterým jsou všichni členové domácnosti spokojeni."
        ),
        syntacticConstructions = listOf(
            "Předložková vazba: bez ohledu na pohlaví",
            "Podmínkové a účelové věty: aby si partneři rozdělili rovným dílem"
        ),
        lexicalPhrases = listOf(
            "rozdělit rovným dílem, tradiční pohled, opravy v domácnosti",
            "vést ke konfliktům, být spokojen s"
        ),
        recommendations = "Užitečné pro procvičení vyjádření spravedlnosti, dělby práce a domácích prací (žehlení, vaření, praní).",
        associationMap = listOf(
            AssociationNode("1. Úvod", "🏁", "Diskuse o rolích.", listOf("Mužské / ženské práce", "Tradiční pohled", "Moderní společnost", "Různé názory")),
            AssociationNode("2. Tradice", "👴", "Tradiční rozdělení.", listOf("Muži: opravy, zahrada", "Ženy: úklid, vaření, děti", "Praktické a přehledné", "Méně konfliktů")),
            AssociationNode("3. Moderní", "🧑‍🍳", "Rovnost v praxi.", listOf("Muž vaří a pere", "Žena opravuje drobnosti", "Spravedlivé dělení", "Oba partneři pracují")),
            AssociationNode("4. Závěr", "🎯", "Finální řešení.", listOf("Každá rodina je jiná", "Záleží na domluvě", "Spokojenost členů"))
        ),
        examCards = listOf(
            ExamCard("Jaké práce vykonávají v domácnosti muži podle tradičního pohledu?", "Tradice", listOf("opravy", "stěhování", "zahrada")),
            ExamCard("Proč by se v moderní rodině měly domácí práce dělit rovným dílem?", "Rovnost", listOf("ženy pracují", "spravedlivé", "bez ohledu na pohlaví")),
            ExamCard("Co by podle vás měl umět v domácnosti udělat každý dospělý člověk?", "Základ", listOf("vařit", "uklidit", "vyprat")),
            ExamCard("Jak máte rozdělené domácí práce u vás doma?", "Osobní", listOf("my se dělíme...", "já většinou...", "můj partner..."), "Uveďte konkrétní rozdělení úkolů.")
        )
    )
)
