-- MySQL dump 10.13  Distrib 8.0.23, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: iFindBook
-- ------------------------------------------------------
-- Server version	8.0.23-0ubuntu0.20.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book_cate`
--

DROP TABLE IF EXISTS `book_cate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book_cate` (
  `b_id` int NOT NULL,
  `c_id` int NOT NULL,
  PRIMARY KEY (`b_id`,`c_id`),
  KEY `book_cate_ibfk_2` (`c_id`),
  CONSTRAINT `book_cate_ibfk_1` FOREIGN KEY (`b_id`) REFERENCES `books` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `book_cate_ibfk_2` FOREIGN KEY (`c_id`) REFERENCES `categaries` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_cate`
--

LOCK TABLES `book_cate` WRITE;
/*!40000 ALTER TABLE `book_cate` DISABLE KEYS */;
INSERT INTO `book_cate` VALUES (7,7),(9,7),(10,7),(11,7),(1,8),(6,8),(7,8),(4,10),(2,11),(3,11),(5,23),(8,37);
/*!40000 ALTER TABLE `book_cate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `short_desc` varchar(255) DEFAULT NULL,
  `long_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'幸存者','安德烈亚斯','https://img9.doubanio.com/view/subject/s/public/s33850014.jpg','用人类灵魂深处的神性撼动造物主的铁腕','作者在故事中为人类制造了一个困境：如果造物主既不像上帝一样怜爱世人，又不像女娲一样心怀母爱，反而冰冷迟钝、不分善恶，那么当它要为自身利益牺牲人类时，我们有机会幸存吗？答案是：人类虽然渺小，却具备造物主没有的智慧和献身精神，这是我们深藏于灵魂中的神性，也是我们微小的胜算。'),(2,'弃猫','村上春树','https://img3.doubanio.com/view/subject/l/public/s33783660.jpg','有些事会随着时间被忘记，有些事则会被时间重新提起。','“某个夏日的午后，父亲和我一同去海边遗弃一只猫。”故事始于猫，也止于猫。一件件生活中的小事，串起村上家族的往事，与他个人的成长经历。“正是这一件件小事无穷地累积，才让我这个人长成如今的模样。”'),(3,'草枕','夏目漱石','https://img1.doubanio.com/view/subject/l/public/s27309159.jpg','一个青年画家为了躲避俗世的忧烦，寻求\"非人情\"的美的世界，来到了一个偏远的山村，以及在那里的所见所思所闻。','作品着重描写了山村中的人和景物，其间穿插着大量\"我\"关于艺术论和美学观的独白，并比较了东西方艺术的差异。这些独白中最为核心的观点即\"非人情\"。所谓\"非人情\"是一种超越道德或人情的境界，是超脱世俗的出世境地，也是一种艺术审美观。比如作品中的\"我\"认为陶渊明的诗中所传达出来的意境便深得\"非人情\"三昧。'),(4,'哨鹿','西幸','https://img2.doubanio.com/view/subject/l/public/s29824852.jpg','...','《哨鹿》為西西創作生涯之第二部長篇小說，兼以傳統與現代的敘事技巧，深刻而廣大地處理了史實與虛構激盪而出的時代人性，佈焗開闊而細緻，角色心理引人入勝，而其中藉以展現西西驚人的小說藝術者，更有嚴謹以雙主線平衡發展，互為糾纏呼應的主線之結構，名批評家林以亮稱之為交響曲結構，於 此一端更超越了英人赫克斯雷（Aldous Huxley）三十年代所經營的長篇《對位法》云。'),(5,'设计中的设计','原研哉','https://img2.doubanio.com/view/subject/s/public/s2165932.jpg','...','设计到底是什么？作为一名从业二十余年并且具有世界影响的设计师，原研哉对自己提出了这样一个问题。为了给出自己的答案，他走了那么长的路，做了那么多的探索。“RE-DESIGN——二十一世纪的日常用品再设计”展真是一个有趣的展览，但又不仅仅是有趣，它分明是为我们揭示了“日常生活”所具有的无限可能性。若我们能以满怀新鲜的眼神去观照日常，“设计”的意义定会超越技术的层面，为我们的生活观和人生观注入力量。'),(6,'沉默的病人','亚历克斯·麦克利兹','https://img1.doubanio.com/view/subject/s/public/s33776227.jpg','多少看似完美的夫妻，都在等待杀死对方的契机。','杀死丈夫时，艾丽西亚33岁。\n\n她往丈夫脸上连开五枪，从此不再说一个字。她被精神诊所收容，成为臭名昭著的“沉默的病人”，唯一留给外界的，只有一副诡异的自画像。\n\n我，心理治疗师西 奥，被她的故事所吸引，希望能通过心理 治疗，帮助她走出沉默的死局。我确信，只有她能述说真相，只有我能使她开口。\n\n哪怕艾丽西亚的沉默背后，是远超我想象的黑暗深渊，正引诱我步步深入，直到万劫不复……\n\n当她真的开始述说真相，我又真的有胆量倾听吗？'),(7,'默读','Priest','https://img1.doubanio.com/view/subject/s/public/s29663109.jpg','童年，成长经历，家庭背景，社会关系，创伤……','我们不断追溯与求索犯罪者的动机，探寻其中最幽微的喜怒哀乐，不是为了设身处地地同情、乃至于原谅他们，不是为了给罪行以开脱的理由，不是为了跪服于所谓人性的复杂，不是为了反思社会矛盾，更不是为了把自己也异化成怪物——\n\n我们只是在给自己、给仍然对这个世界抱有期望的人——寻找一个公正的交代。'),(8,'神经网络与深度学习','邱锡鹏','https://img1.doubanio.com/view/subject/s/public/s33631858.jpg','...','本书主要介绍神经网络与深度学习中的基础知识、主要模型（卷积神经网络、递归神经网络等）以及在计算机视觉、自然语言处理等领域的应用。'),(9,'活着','余华','https://img3.doubanio.com/view/subject/s/public/s29053580.jpg','《活着》讲述了农村人福贵悲惨的人生遭遇。','福贵本是个阔少爷，可他嗜赌如命，终于赌光了家业，一贫如洗。他的父亲被他活活气死，母亲则在穷困中患了重病，福贵前去求药，却在途中被国民党抓去当壮丁。经过几番波折回到家里，才知道母亲早已去世，妻子家珍含辛茹苦地养大两个儿女。此后更加悲惨的命运一次又一次降临到福贵身上，他的妻子、儿女和孙子相继死去，最后只剩福贵和一头老牛相依为命，但老人依旧活着，仿佛比往日更加洒脱与坚强。'),(10,'文城','余华','https://img1.doubanio.com/view/subject/s/public/s33834057.jpg','述南方小镇上各色人物的爱恨悲欢','在溪镇人最初的印象里，林祥福是一个身上披戴雪花，头发和胡子遮住脸庞的男人，有着垂柳似的谦卑和田地般的沉默寡言。哪怕后来成了万亩荡和木器社的主人，他身上的谦卑和沉默依旧没有变。他的过去和一座谜一样的城联系在了一起，没人知道他为什么要找一个不存在的地方。\n\n他原本不属于这里，他的家乡在遥远的北方。为了一个承诺他将自己连根拔起，漂泊至此。往后的日子，他见识过温暖赤诚的心，也见识过冰冷无情的血。最终他徒劳无获，但许多人的牵挂和眼泪都留在了他身上。\n\n“文城在哪里？”\n\n“总会有一个地方叫文城。”'),(11,'房思琪的初恋乐园','林奕含','https://img3.doubanio.com/view/subject/s/public/s29651121.jpg','令人心碎却无能为力的真实故事。','我下楼拿作文给李老师改。他掏出来，我被逼到涂在墙上。老师说了九个字：“不行的话，嘴巴可以吧。”我说了五个字：“不行，我不会。”他就塞进来。那感觉像溺水。可以说话之后，我对老师说：“对不起。”有一种功课做不好的感觉。\n\n小小的房思琪住在金碧辉煌的人生里，她的脸和她可以想象的将来一样漂亮。补习班语文名师李国华是同一栋高级住宅的邻居。崇拜文学的小房思琪同样崇拜饱读诗书的李老师。\n\n有一天李老师说，你的程度这么好，不如每个礼拜交一篇作文给我吧，不收你周点费。思琪听话地下楼了。老师在家里等她，桌上没有纸笔...');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categaries`
--

DROP TABLE IF EXISTS `categaries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categaries` (
  `id` int NOT NULL,
  `p_id` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cate_ibfk_1` (`p_id`),
  CONSTRAINT `cate_ibfk_1` FOREIGN KEY (`p_id`) REFERENCES `categaries` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categaries`
--

LOCK TABLES `categaries` WRITE;
/*!40000 ALTER TABLE `categaries` DISABLE KEYS */;
INSERT INTO `categaries` VALUES (1,NULL,'文学'),(2,NULL,'流行'),(3,NULL,'文化'),(4,NULL,'生活'),(5,NULL,'经管'),(6,NULL,'科技'),(7,1,'小说'),(8,1,'外国文学'),(9,1,'中国文学'),(10,1,'散文'),(11,1,'当代文学'),(12,1,'杂文'),(13,2,'推理'),(14,2,'科幻'),(15,2,'武侠'),(16,2,'耽美'),(17,2,'穿越'),(18,2,'漫画'),(19,3,'历史'),(20,3,'心理学'),(21,3,'艺术'),(22,3,'社会'),(23,3,'设计'),(24,3,'音乐'),(25,4,'爱情'),(26,4,'旅行'),(27,4,'摄影'),(28,4,'养生'),(29,4,'美食'),(30,4,'职场'),(31,5,'经济学'),(32,5,'管理'),(33,5,'商业'),(34,5,'金融'),(35,5,'广告'),(36,5,'策划'),(37,6,'编程'),(38,6,'交互'),(39,6,'科普'),(40,6,'算法'),(41,6,'UCD'),(42,6,'通信');
/*!40000 ALTER TABLE `categaries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fav`
--

DROP TABLE IF EXISTS `fav`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fav` (
  `u_id` int NOT NULL,
  `b_id` int NOT NULL,
  PRIMARY KEY (`u_id`,`b_id`),
  KEY `b_id` (`b_id`),
  CONSTRAINT `fav_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`),
  CONSTRAINT `fav_ibfk_2` FOREIGN KEY (`b_id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fav`
--

LOCK TABLES `fav` WRITE;
/*!40000 ALTER TABLE `fav` DISABLE KEYS */;
INSERT INTO `fav` VALUES (2,1),(1,2),(1,6),(1,11);
/*!40000 ALTER TABLE `fav` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `read`
--

DROP TABLE IF EXISTS `read`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `read` (
  `u_id` int NOT NULL,
  `b_id` int NOT NULL,
  PRIMARY KEY (`u_id`,`b_id`),
  KEY `b_id` (`b_id`),
  CONSTRAINT `read_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`),
  CONSTRAINT `read_ibfk_2` FOREIGN KEY (`b_id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `read`
--

LOCK TABLES `read` WRITE;
/*!40000 ALTER TABLE `read` DISABLE KEYS */;
INSERT INTO `read` VALUES (1,2),(1,5),(1,6);
/*!40000 ALTER TABLE `read` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reading`
--

DROP TABLE IF EXISTS `reading`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reading` (
  `u_id` int NOT NULL,
  `b_id` int NOT NULL,
  PRIMARY KEY (`u_id`,`b_id`),
  KEY `b_id` (`b_id`),
  CONSTRAINT `reading_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`),
  CONSTRAINT `reading_ibfk_2` FOREIGN KEY (`b_id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reading`
--

LOCK TABLES `reading` WRITE;
/*!40000 ALTER TABLE `reading` DISABLE KEYS */;
INSERT INTO `reading` VALUES (1,11);
/*!40000 ALTER TABLE `reading` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recmd`
--

DROP TABLE IF EXISTS `recmd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recmd` (
  `b_id` int NOT NULL,
  PRIMARY KEY (`b_id`),
  CONSTRAINT `recmd_ibfk_1` FOREIGN KEY (`b_id`) REFERENCES `books` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recmd`
--

LOCK TABLES `recmd` WRITE;
/*!40000 ALTER TABLE `recmd` DISABLE KEYS */;
INSERT INTO `recmd` VALUES (1),(3),(9);
/*!40000 ALTER TABLE `recmd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '	',
  `account` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_UNIQUE` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','老陈','admin','1321500713_4IT6LF@KINDLE.cn'),(2,'admin2','老陈2','admin2',NULL),(9,'carlchen','carlchen23','123',''),(11,'admin3','老陈3','admin3','carlchenxq@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'iFindBook'
--

--
-- Dumping routines for database 'iFindBook'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-08 15:02:17
