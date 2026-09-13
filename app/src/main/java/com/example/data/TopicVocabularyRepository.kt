package com.example.data

object TopicVocabularyRepository {

    fun getKeyWords(topicId: String): List<KeyWord> {
        return vocabMap[topicId] ?: generateFallbackVocab(topicId)
    }

    private val vocabMap: Map<String, List<KeyWord>> = mapOf(
        "more-hory" to listOf(
            KeyWord(
                id = "mh_1",
                czech = "šumění vln",
                english = "sound / murmur of waves",
                russian = "шум волн",
                example = "Rád ležím na pláži a poslouchám šumění vln.",
                exampleEn = "I like lying on the beach and listening to the murmur of the waves.",
                exampleRu = "Мне нравится лежать на пляже и слушать шум волн.",
                clozeSentence = "Na pláži můžete odpočívat a poslouchat _____ vln.",
                clozeOptions = listOf("šumění", "počasí", "túry", "kondici")
            ),
            KeyWord(
                id = "mh_2",
                czech = "dávat přednost",
                english = "to prefer / give preference to",
                russian = "отдавать предпочтение",
                example = "Mnoho lidí dává přednost horám před mořem.",
                exampleEn = "Many people give preference to mountains over the sea.",
                exampleRu = "Многие люди отдают предпочтение горам перед морем.",
                clozeSentence = "Někteří lidé dávají _____ aktivní dovolené.",
                clozeOptions = listOf("přednost", "názor", "výdaje", "přátelství")
            ),
            KeyWord(
                id = "mh_3",
                czech = "být v dobré kondici",
                english = "to be in good physical shape",
                russian = "быть в хорошей форме",
                example = "V horách musíte být v dobré kondici, protože túry jsou náročné.",
                exampleEn = "In the mountains you have to be in good shape because hikes are demanding.",
                exampleRu = "В горах нужно быть в хорошей физической форме, так как походы трудные.",
                clozeSentence = "Při náročných túrách v horách je nutné být v dobré _____.",
                clozeOptions = listOf("kondici", "polévce", "společnosti", "zásobě")
            ),
            KeyWord(
                id = "mh_4",
                czech = "nevyzpytatelné počasí",
                english = "unpredictable weather",
                russian = "непредсказуемая погода",
                example = "Počasí v horách je často nevyzpytatelné.",
                exampleEn = "Weather in the mountains is often unpredictable.",
                exampleRu = "Погода в горах часто непредсказуема.",
                clozeSentence = "V horách vás může překvapit _____ počasí.",
                clozeOptions = listOf("nevyzpytatelné", "oblíbené", "levné", "slušné")
            ),
            KeyWord(
                id = "mh_5",
                czech = "omrzet (koho)",
                english = "to get tired of / grow weary of",
                russian = "надоесть / наскучить",
                example = "Pokud nemáte rádi vedro, moře vás rychle omrzí.",
                exampleEn = "If you do not like the heat, the sea will quickly bore you.",
                exampleRu = "Если вы не любите жару, море вам быстро наскучит.",
                clozeSentence = "Po týdnu ležení na pláži mě to začalo _____.",
                clozeOptions = listOf("omrzet", "stěhovat", "vyzkoušet", "vařit")
            ),
            KeyWord(
                id = "mh_6",
                czech = "přeplněný",
                english = "crowded / overcrowded",
                russian = "переполненный",
                example = "V létě jsou pláže často přeplněné turisty.",
                exampleEn = "In summer the beaches are often overcrowded with tourists.",
                exampleRu = "Летом пляжи часто переполнены туристами.",
                clozeSentence = "V hlavní turistické sezóně bývají pláže hodně _____.",
                clozeOptions = listOf("přeplněné", "nezdravé", "snadné", "čerstvé")
            )
        ),
        "dum-byt" to listOf(
            KeyWord(
                id = "db_1",
                czech = "starat se o (koho/co)",
                english = "to take care of / look after (+ acc.)",
                russian = "заботиться о / ухаживать за (+ вин. п.)",
                example = "U rodinného domu se musíte starat o velkou zahradu.",
                exampleEn = "With a family house you have to take care of a large garden.",
                exampleRu = "В частном доме нужно ухаживать за большим садом.",
                clozeSentence = "Majitel domu se musí neustále _____ o údržbu.",
                clozeOptions = listOf("starat", "dělit", "dojíždět", "stěžovat")
            ),
            KeyWord(
                id = "db_2",
                czech = "soukromí",
                english = "privacy",
                russian = "личное пространство / уединение",
                example = "Bydlení v domě poskytuje rodině více soukromí.",
                exampleEn = "Living in a house provides the family with more privacy.",
                exampleRu = "Жизнь в доме обеспечивает семье больше уединения.",
                clozeSentence = "V rodinném domě máme více klidu a rodinného _____.",
                clozeOptions = listOf("soukromí", "spojení", "počasí", "nebezpečí")
            ),
            KeyWord(
                id = "db_3",
                czech = "údržba",
                english = "maintenance / upkeep",
                russian = "техническое обслуживание / содержание",
                example = "V bytě většinu údržby řeší správce domu.",
                exampleEn = "In a flat, most maintenance is handled by the building manager.",
                exampleRu = "В квартире большую часть обслуживания решает управляющий домом.",
                clozeSentence = "Bydlení v bytě je pohodlnější, protože _____ zajišťuje správce.",
                clozeOptions = listOf("údržbu", "túru", "vzdělání", "klimatizaci")
            ),
            KeyWord(
                id = "db_4",
                czech = "dělit se o (co)",
                english = "to share (something)",
                russian = "делиться чем-то / делить (пространство)",
                example = "V bytovém domě se musíte dělit o chodbu a výtah se sousedy.",
                exampleEn = "In an apartment building you have to share the corridor and elevator with neighbors.",
                exampleRu = "В многоквартирном доме приходится делить коридор и лифт с соседями.",
                clozeSentence = "V bytě se nájemníci musí _____ o společné prostory.",
                clozeOptions = listOf("dělit", "bavit", "vybírat", "odmítat")
            ),
            KeyWord(
                id = "db_5",
                czech = "finančně náročný",
                english = "financially demanding / expensive",
                russian = "финансово затратный / дорогостоящий",
                example = "Oprava střechy může být velmi finančně náročná.",
                exampleEn = "Repairing the roof can be very financially demanding.",
                exampleRu = "Ремонт крыши может быть очень затратным в финансовом плане.",
                clozeSentence = "Stavba a rekonstrukce domu je časově i finančně _____.",
                clozeOptions = listOf("náročná", "příjemná", "přátelská", "zdravá")
            ),
            KeyWord(
                id = "db_6",
                czech = "společné prostory",
                english = "common / shared areas",
                russian = "места общего пользования",
                example = "Mezi společné prostory v domě patří kočárkárna a schodiště.",
                exampleEn = "Shared areas in the building include the stroller room and stairwell.",
                exampleRu = "К местам общего пользования в доме относятся колясочная и лестница.",
                clozeSentence = "Úklid pro _____ prostory často zajišťuje úklidová firma.",
                clozeOptions = listOf("společné", "chutné", "nebezpečné", "přírodní")
            )
        ),
        "mesto-vesnice" to listOf(
            KeyWord(
                id = "mv_1",
                czech = "občanská vybavenost",
                english = "civic amenities / local services",
                russian = "социальная инфраструктура / удобства",
                example = "Ve městě je vynikající občanská vybavenost.",
                exampleEn = "The city has excellent civic amenities.",
                exampleRu = "В городе отличная социальная инфраструктура.",
                clozeSentence = "Ve městě je výhodou skvělá občanská _____ – obchody a lékaři.",
                clozeOptions = listOf("vybavenost", "povinnost", "zábava", "rychlost")
            ),
            KeyWord(
                id = "mv_2",
                czech = "dojíždět do práce",
                english = "to commute to work",
                russian = "ездить на работу (на расстояние)",
                example = "Z vesnice musíte denně dojíždět do práce autem nebo vlakem.",
                exampleEn = "From the village you have to commute daily to work by car or train.",
                exampleRu = "Из деревни приходится ежедневно ездить на работу на машине или поезде.",
                clozeSentence = "Lidé z předměstí musí často _____ do centra za prací.",
                clozeOptions = listOf("dojíždět", "podnikat", "nakupovat", "třídit")
            ),
            KeyWord(
                id = "mv_3",
                czech = "životní tempo",
                english = "pace of life",
                russian = "темп жизни",
                example = "Na vesnici je životní tempo pomalejší a klidnější.",
                exampleEn = "In the village the pace of life is slower and calmer.",
                exampleRu = "В деревне темп жизни более медленный и спокойный.",
                clozeSentence = "V metropoli bývá velmi rychlé životní _____.",
                clozeOptions = listOf("tempo", "jízdné", "počasí", "ticho")
            ),
            KeyWord(
                id = "mv_4",
                czech = "dopravní zácpa",
                english = "traffic jam",
                russian = "автомобильная пробка",
                example = "Ráno v hlavním městě často stojíme v dopravní zácpě.",
                exampleEn = "In the morning in the capital we often sit in a traffic jam.",
                exampleRu = "Утром в столице мы часто стоим в автомобильной пробке.",
                clozeSentence = "V ranní špičce vzniká na dálnici velká dopravní _____.",
                clozeOptions = listOf("zácpa", "zahrada", "nabídka", "výstava")
            ),
            KeyWord(
                id = "mv_5",
                czech = "čerstvý vzduch",
                english = "fresh air",
                russian = "свежий воздух",
                example = "Na venkově lidé oceňují čistou přírodu a čerstvý vzduch.",
                exampleEn = "In the countryside people appreciate clean nature and fresh air.",
                exampleRu = "В сельской местности люди ценят чистую природу и свежий воздух.",
                clozeSentence = "Na venkově si užívám klid a čistý, _____ vzduch.",
                clozeOptions = listOf("čerstvý", "hlučný", "plný", "umělý")
            ),
            KeyWord(
                id = "mv_6",
                czech = "společenský život",
                english = "social / cultural life",
                russian = "общественная жизнь",
                example = "Město nabízí bohatý společenský život, kina a divadla.",
                exampleEn = "The city offers a rich social life, cinemas and theaters.",
                exampleRu = "Город предлагает богатую общественную жизнь, кино и театры.",
                clozeSentence = "Pro mladé lidi je ve městě lákavý pestrý _____ život.",
                clozeOptions = listOf("společenský", "domácí", "vesnický", "tichý")
            )
        ),
        "zdrave-jidlo" to listOf(
            KeyWord(
                id = "zj_1",
                czech = "vyvážená strava",
                english = "balanced diet",
                russian = "сбалансированное питание",
                example = "Základem zdraví je pestrá a vyvážená strava.",
                exampleEn = "The foundation of health is a diverse and balanced diet.",
                exampleRu = "Основа здоровья — разнообразное и сбалансированное питание.",
                clozeSentence = "Lékaři doporučují, aby naše strava byla zdravá a _____.",
                clozeOptions = listOf("vyvážená", "sladká", "rychlá", "levná")
            ),
            KeyWord(
                id = "zj_2",
                czech = "stravovací návyky",
                english = "eating habits",
                russian = "пищевые привычки",
                example = "Změnit špatné stravovací návyky vyžaduje pevnou vůli.",
                exampleEn = "Changing bad eating habits requires strong willpower.",
                exampleRu = "Изменение вредных пищевых привычек требует силы воли.",
                clozeSentence = "Měli bychom zlepšit své každodenní stravovací _____.",
                clozeOptions = listOf("návyky", "příbory", "dárky", "dny")
            ),
            KeyWord(
                id = "zj_3",
                czech = "obsahovat vitamíny",
                english = "to contain vitamins",
                russian = "содержать витамины",
                example = "Ovoce a zelenina obsahují mnoho vitamínů a minerálů.",
                exampleEn = "Fruit and vegetables contain lots of vitamins and minerals.",
                exampleRu = "Фрукты и овощи содержат много витаминов и минералов.",
                clozeSentence = "Čerstvá brokolice a mrkev _____ důležité vitamíny.",
                clozeOptions = listOf("obsahují", "vaří", "kupují", "zapomínají")
            ),
            KeyWord(
                id = "zj_4",
                czech = "vynechávat jídlo",
                english = "to skip meals",
                russian = "пропускать прием пищи",
                example = "Není zdravé vynechávat snídani nebo oběd.",
                exampleEn = "It is not healthy to skip breakfast or lunch.",
                exampleRu = "Пропускать завтрак или обед не полезно для здоровья.",
                clozeSentence = "Pokud spěcháte, neměli byste _____ snídani.",
                clozeOptions = listOf("vynechávat", "chutnat", "dělit", "nabízet")
            ),
            KeyWord(
                id = "zj_5",
                czech = "být bohatý na (co)",
                english = "to be rich in (+ acc.)",
                russian = "быть богатым чем-то (+ вин. п.)",
                example = "Ryby jsou bohaté na omega-3 mastné kyseliny.",
                exampleEn = "Fish is rich in omega-3 fatty acids.",
                exampleRu = "Рыба богата жирными кислотами омега-3.",
                clozeSentence = "Luštěniny jsou velmi bohaté _____ bílkoviny.",
                clozeOptions = listOf("na", "o", "v", "za")
            ),
            KeyWord(
                id = "zj_6",
                czech = "omezit spotřebu",
                english = "to reduce consumption",
                russian = "ограничить потребление",
                example = "Je důležité omezit spotřebu cukru a bílého pečiva.",
                exampleEn = "It is important to reduce consumption of sugar and white bread.",
                exampleRu = "Важно ограничить потребление сахара и белой выпечки.",
                clozeSentence = "Pro lepší zdraví je vhodné _____ spotřebu soli a sladkostí.",
                clozeOptions = listOf("omezit", "zvýšit", "zaplatit", "pozvat")
            )
        ),
        "svatky" to listOf(
            KeyWord(
                id = "sv_1",
                czech = "rodinné setkání",
                english = "family gathering / reunion",
                russian = "семейная встреча / воссоединение",
                example = "Vánoce jsou příležitostí pro velké rodinné setkání.",
                exampleEn = "Christmas is an occasion for a large family gathering.",
                exampleRu = "Рождество — это повод для большой семейной встречи.",
                clozeSentence = "O svátcích se těším na milé rodinné _____.",
                clozeOptions = listOf("setkání", "dojíždění", "omezení", "úklidy")
            ),
            KeyWord(
                id = "sv_2",
                czech = "udržovat tradice",
                english = "to maintain / keep traditions",
                russian = "поддерживать традиции",
                example = "Mnoho českých rodin rádo udržuje lidové tradice.",
                exampleEn = "Many Czech families like to maintain folk traditions.",
                exampleRu = "Многие чешские семьи любят поддерживать народные традиции.",
                clozeSentence = "Je důležité předávat a _____ kulturní tradice mladší generaci.",
                clozeOptions = listOf("udržovat", "utrácet", "přerušit", "vyhazovat")
            ),
            KeyWord(
                id = "sv_3",
                czech = "finanční výdaje",
                english = "financial expenses",
                russian = "финансовые расходы",
                example = "Nákup dárků a jídla představuje značné finanční výdaje.",
                exampleEn = "Buying presents and food represents significant financial expenses.",
                exampleRu = "Покупка подарков и еды представляет собой значительные финансовые расходы.",
                clozeSentence = "Před Vánocemi mívají rodiny vysoké finanční _____.",
                clozeOptions = listOf("výdaje", "hodiny", "vlaky", "pláže")
            ),
            KeyWord(
                id = "sv_4",
                czech = "těšit se na (koho/co)",
                english = "to look forward to (+ acc.)",
                russian = "с нетерпением ждать / радоваться чему-то",
                example = "Děti se velmi těší na vánoční stromeček a dárky.",
                exampleEn = "Children look forward very much to the Christmas tree and presents.",
                exampleRu = "Дети очень ждут рождественскую елку и подарки.",
                clozeSentence = "Celý rok se _____ na letní prázdniny a Vánoce.",
                clozeOptions = listOf("těším", "stěžuji", "bojím", "dělím")
            ),
            KeyWord(
                id = "sv_5",
                czech = "zpomalit tempo",
                english = "to slow down the pace",
                russian = "замедлить темп",
                example = "Během svátků můžeme konečně zpomalit tempo a odpočívat.",
                exampleEn = "During holidays we can finally slow down the pace and rest.",
                exampleRu = "Во время праздников мы можем наконец замедлить темп и отдохнуть.",
                clozeSentence = "Svátky nám dávají šanci vypnout telefon a _____ tempo.",
                clozeOptions = listOf("zpomalit", "zrychlit", "vymyslet", "spálit")
            ),
            KeyWord(
                id = "sv_6",
                czech = "zapomenout na starosti",
                english = "to forget about worries",
                russian = "забыть о заботах / тревогах",
                example = "V kruhu přátel je snadné zapomenout na starosti všedního dne.",
                exampleEn = "In the circle of friends it is easy to forget the worries of everyday life.",
                exampleRu = "В кругу друзей легко забыть о повседневных заботах.",
                clozeSentence = "Při oslavě se snažím _____ na pracovní povinnosti.",
                clozeOptions = listOf("zapomenout", "vzpomínat", "objednat", "přidat")
            )
        ),
        "nakupovani" to listOf(
            KeyWord(
                id = "nak_1",
                czech = "kamenný obchod",
                english = "brick-and-mortar store",
                russian = "традиционный (физический) магазин",
                example = "V kamenném obchodě si zboží mohu hned vyzkoušet.",
                exampleEn = "In a brick-and-mortar store I can try the goods right away.",
                exampleRu = "В физическом магазине я могу сразу примерить товар.",
                clozeSentence = "Mnoho lidí stále dává přednost nákupu v _____ obchodě.",
                clozeOptions = listOf("kamenném", "nočním", "dřevěném", "levném")
            ),
            KeyWord(
                id = "nak_2",
                czech = "vyzkoušet si (oblečení)",
                english = "to try on (clothes)",
                russian = "примерить (одежду)",
                example = "Před nákupem nových bot je nutné si je vyzkoušet.",
                exampleEn = "Before buying new shoes it is necessary to try them on.",
                exampleRu = "Перед покупкой новой обуви обязательно нужно ее примерить.",
                clozeSentence = "V kabince v obchodě si můžu kabát nejdříve _____.",
                clozeOptions = listOf("vyzkoušet", "objednat", "doručit", "odložit")
            ),
            KeyWord(
                id = "nak_3",
                czech = "doručení až domů",
                english = "home delivery",
                russian = "доставка прямо на дом",
                example = "Při online nákupu oceňuji rychlé doručení až domů.",
                exampleEn = "When shopping online I appreciate fast delivery right to my home.",
                exampleRu = "При покупках онлайн я ценю быструю доставку прямо на дом.",
                clozeSentence = "Kurýr zajistí bezpečné _____ balíčku až do bytu.",
                clozeOptions = listOf("doručení", "vyzkoušení", "zpoždění", "vaření")
            ),
            KeyWord(
                id = "nak_4",
                czech = "vrácení zboží",
                english = "product return / refund",
                russian = "возврат товара",
                example = "Zákazník má ze zákona právo na vrácení zboží do čtrnácti dnů.",
                exampleEn = "The customer has by law the right to return goods within fourteen days.",
                exampleRu = "По закону покупатель имеет право на возврат товара в течение четырнадцати дней.",
                clozeSentence = "Pokud vám velikost nesedí, můžete využít bezplatné _____ zboží.",
                clozeOptions = listOf("vrácení", "ukradení", "hledání", "pálení")
            ),
            KeyWord(
                id = "nak_5",
                czech = "uživatelské recenze",
                english = "user reviews",
                russian = "отзывы пользователей / покупателей",
                example = "Před koupí elektroniky si vždy přečtu recenze zákazníků.",
                exampleEn = "Before purchasing electronics I always read customer reviews.",
                exampleRu = "Перед покупкой электроники я всегда читаю отзывы покупателей.",
                clozeSentence = "Na internetu si snadno přečteme hodnocení a _____ jiných lidí.",
                clozeOptions = listOf("recenze", "recepty", "předpovědi", "úkoly")
            ),
            KeyWord(
                id = "nak_6",
                czech = "stát ve frontě",
                english = "to stand in line / queue",
                russian = "стоять в очереди",
                example = "U pokladny v supermarketu nechci dlouho stát ve frontě.",
                exampleEn = "At the checkout in the supermarket I do not want to stand in a queue for long.",
                exampleRu = "У кассы в супермаркете я не хочу долго стоять в очереди.",
                clozeSentence = "Při nákupech na internetu nemusíte čekat a _____ ve frontě.",
                clozeOptions = listOf("stát", "jet", "spát", "psát")
            )
        )
    )

    private fun generateFallbackVocab(topicId: String): List<KeyWord> {
        val title = topicId.replace("-", " ")
        return listOf(
            KeyWord(
                id = "${topicId}_1",
                czech = "z mého pohledu",
                english = "from my perspective / in my view",
                russian = "с моей точки зрения / по моему мнению",
                example = "Z mého pohledu je toto téma velmi aktuální a důležité.",
                exampleEn = "In my view, this topic is very relevant and important.",
                exampleRu = "С моей точки зрения, эта тема очень актуальна и важна.",
                clozeSentence = "_____ je klíčové zvážit všechny výhody i nevýhody.",
                clozeOptions = listOf("Z mého pohledu", "Bez ohledu", "Na rozdíl", "Kvůli tomu")
            ),
            KeyWord(
                id = "${topicId}_2",
                czech = "mít vliv na (koho/co)",
                english = "to have an influence / impact on (+ acc.)",
                russian = "влиять / оказывать влияние на (+ вин. п.)",
                example = "Tento faktor má velký vliv na každodenní život.",
                exampleEn = "This factor has a big impact on everyday life.",
                exampleRu = "Этот фактор оказывает большое влияние на повседневную жизнь.",
                clozeSentence = "Moderní životní styl má zásadní _____ na naše zdraví.",
                clozeOptions = listOf("vliv", "názor", "výběr", "úklid")
            ),
            KeyWord(
                id = "${topicId}_3",
                czech = "být zvyklý na (co)",
                english = "to be accustomed / used to (+ acc.)",
                russian = "привыкнуть к / быть привыкшим к (+ вин. п.)",
                example = "Jsem zvyklý na pravidelný denní režim.",
                exampleEn = "I am used to a regular daily routine.",
                exampleRu = "Я привык к регулярному распорядку дня.",
                clozeSentence = "Mnoho cizinců není zvyklých _____ místní počasí a zvyky.",
                clozeOptions = listOf("na", "o", "v", "před")
            ),
            KeyWord(
                id = "${topicId}_4",
                czech = "dávat přednost (čemu)",
                english = "to prefer (something)",
                russian = "отдавать предпочтение (чему-то)",
                example = "Osobně dávám přednost praktickým řešením.",
                exampleEn = "Personally I give preference to practical solutions.",
                exampleRu = "Лично я отдаю предпочтение практичным решениям.",
                clozeSentence = "Při rozhodování většinou _____ prověřeným možnostem.",
                clozeOptions = listOf("dávám přednost", "mám strach", "dělám chybu", "beru ohled")
            ),
            KeyWord(
                id = "${topicId}_5",
                czech = "na jedné straně ..., na druhé straně",
                english = "on the one hand ..., on the other hand",
                russian = "с одной стороны ..., с другой стороны",
                example = "Na jedné straně je to pohodlné, na druhé straně to stojí více peněz.",
                exampleEn = "On the one hand it is convenient, on the other hand it costs more money.",
                exampleRu = "С одной стороны, это удобно, с другой стороны, это стоит больше денег.",
                clozeSentence = "Na jedné straně vidím výhody, na _____ straně vnímám rizika.",
                clozeOptions = listOf("druhé", "první", "třetí", "poslední")
            ),
            KeyWord(
                id = "${topicId}_6",
                czech = "závěrem lze říci",
                english = "in conclusion it can be said",
                russian = "в заключение можно сказать",
                example = "Závěrem lze říci, že každý by si měl vybrat to, co mu vyhovuje.",
                exampleEn = "In conclusion it can be said that everyone should choose what suits them.",
                exampleRu = "В заключение можно сказать, что каждый должен выбрать то, что ему подходит.",
                clozeSentence = "_____ lze shrnout, že tato volba závisí na osobních prioritách.",
                clozeOptions = listOf("Závěrem", "Úvodem", "Zatímco", "Protože")
            )
        )
    }
}
