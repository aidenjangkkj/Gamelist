-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        11.5.2-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- gamedb 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `gamedb` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci */;
USE `gamedb`;

-- 테이블 gamedb.game 구조 내보내기
CREATE TABLE IF NOT EXISTS `game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `genre` varchar(100) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `content` text DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

-- 테이블 데이터 gamedb.game:~10 rows (대략적) 내보내기
INSERT IGNORE INTO `game` (`id`, `title`, `genre`, `price`, `image_url`, `content`) VALUES
	(1, 'The Last of Us Part II', 'Action-Adventure', 59900, 'https://example.com/lastofus2.jpg', 'A gripping story of survival and revenge, with deep character development.'),
	(2, 'Minecraft', 'Sandbox', 26900, 'https://example.com/minecraft.jpg', 'A world-building sandbox game where you can explore, build, and survive.'),
	(3, 'Cyberpunk 2077', 'RPG', 69900, 'https://example.com/cyberpunk2077.jpg', 'An open-world RPG set in a dystopian future, featuring deep customization and narrative choices.'),
	(4, 'Animal Crossing: New Horizons', 'Simulation', 64900, 'https://example.com/animalcrossing.jpg', 'Create and manage your own island paradise, with seasonal events and cozy gameplay.'),
	(5, 'Hades', 'Rogue-like', 24900, 'https://example.com/hades.jpg', 'A rogue-like dungeon crawler with fast-paced combat and a compelling narrative.'),
	(6, 'Grand Theft Auto V', 'Action-Adventure', 49900, 'https://example.com/gtav.jpg', 'A crime-themed action game with open-world exploration and an engaging single-player campaign.'),
	(7, 'Red Dead Redemption 2', 'Action-Adventure', 74900, 'https://example.com/rdr2.jpg', 'An epic tale of outlaws set in the American West, with rich storytelling and stunning visuals.'),
	(8, 'Fortnite', 'Battle Royale', 0, 'https://example.com/fortnite.jpg', 'A fast-paced, free-to-play battle royale game featuring building mechanics and vibrant graphics.'),
	(9, 'The Witcher 3: Wild Hunt', 'RPG', 49900, 'https://example.com/witcher3.jpg', 'An open-world RPG with a rich narrative, immersive world-building, and engaging side quests.'),
	(10, 'Overwatch', 'FPS', 49900, 'https://example.com/overwatch.jpg', 'A team-based first-person shooter with diverse heroes and strategic gameplay.');

-- 테이블 gamedb.review 구조 내보내기
CREATE TABLE IF NOT EXISTS `review` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` text NOT NULL,
  `reviewer_name` varchar(255) NOT NULL,
  `game_id` int(11) NOT NULL,
  PRIMARY KEY (`review_id`),
  KEY `fk_game_id` (`game_id`),
  CONSTRAINT `fk_game_id` FOREIGN KEY (`game_id`) REFERENCES `game` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

-- 테이블 데이터 gamedb.review:~10 rows (대략적) 내보내기
INSERT IGNORE INTO `review` (`review_id`, `comment`, `reviewer_name`, `game_id`) VALUES
	(1, '게임의 스토리와 그래픽이 탁월하다. 추천!', '김민수', 1),
	(2, '무한한 창작의 자유를 제공하는 게임. 모든 연령대가 즐길 수 있다.', '이영희', 1),
	(3, '복잡한 스토리와 멋진 그래픽. 그러나 버그가 많다.', '박지훈', 3),
	(4, '편안한 게임 플레이와 아름다운 그래픽. 스트레스 해소에 좋다.', '최지은', 4),
	(5, '도전적인 게임 플레이와 훌륭한 스토리. 재도전할 가치가 있다.', '홍길동', 8),
	(6, '넓은 오픈 월드와 재미있는 미션들. 온라인 모드도 즐길 수 있다.', '정유진', 6),
	(7, '세밀한 그래픽과 몰입감 넘치는 스토리. 최고의 오픈 월드 게임 중 하나.', '박상호', 5),
	(8, '재미있는 멀티플레이어 배틀로얄 게임. 친구들과 함께 즐기기에 좋다.', '배수지', 5),
	(9, '세밀한 세계관과 흥미로운 퀘스트. RPG의 명작.', '임동혁', 3),
	(10, '팀워크가 중요한 재미있는 FPS 게임. 캐릭터들이 매력적이다.', '김서연', 10);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
