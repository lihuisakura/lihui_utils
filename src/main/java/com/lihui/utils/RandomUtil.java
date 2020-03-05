package com.lihui.utils;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

public class RandomUtil {

	/**
	 * 
	 * @Title: getRandom 
	 * @Description: 取0~9的随机数
	 * @return
	 * @return: int
	 */
	public static int getRandomNum() {
		Random random = new Random();
		int num = random.nextInt(10);
		return num;
	}
	/**
	 * 
	 * @Title: getRandom 
	 * @Description: 获得随机0-9之间的指定个数的数字
	 * @param count
	 * @return
	 * @return: int
	 */
	public static int[] getRandomNum(int count) {
		int[] num=new int[count];
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size()<count) {
			Integer n=getRandomNum();
			set.add(n);
		}
		int i=0;
		for (Integer integer : set) {
			num[i++]=integer;
		}
		return num;
	}
	/**
	 * 
	 * @Title: getRandom 
	 * @Description: 获得一个区间内的随机数字  3   15
	 * @param max
	 * @param min
	 * @return
	 * @return: int
	 */
	public static int getRandomNum(int max,int min) {
		Random random = new Random();
		int num = random.nextInt(max-min+1)+min;
		return num;
	}
	/**
	 * 
	 * @Title: getRandom 
	 * @Description: 获得一个区间内的n个不会重复的随机数字 3   15
	 * @param max
	 * @param min
	 * @param count
	 * @return
	 * @return: int[]
	 */
	public static int[] getRandomNum(int max,int min,int count) {
		int[] num=new int[count];
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size()<count) {
			Integer n=getRandomNum(max,min);
			set.add(n);
		}
		int i=0;
		for (Integer integer : set) {
			num[i++]=integer;
		}
		return num;
	}
	
	/**
	 * 
	 * @Title: getRandomEnglish 
	 * @Description: 获得随机英文字符
	 * @return
	 * @return: char
	 */
	public static char getRandomEnglish() {
		Random random = new Random();
		char english='a';
		return (char)(random.nextInt(26)+english);
	}
	/**
	 * 
	 * @Title: getRandomNumberAndEnglishString 
	 * @Description: 获取n位随机英文和数字字符串
	 * @return
	 * @return: String
	 */
	public static String getRandomNumberAndEnglishString(int count) {
		Random random = new Random();
		StringBuffer string=new StringBuffer();
		for (int i = 0; i < count; i++) {
			//10位数字 26个字母 
			int num = random.nextInt(36);
			if(num>10) {
				string.append(getRandomEnglish());
			}else {
				string.append(getRandomNum());
			}
		}
		return string.toString();
	}
	
	//获取1个随机中文字符串
		public static String getRandomChineseString() {
			Random random=new Random();
			//常用汉字的高位字节最小值是176 
			//39 一级汉字 16-55区  55-16=39
			int highPos=176+Math.abs(random.nextInt(39));
			//常用汉字的低位字节最小值是161  a0 0+160+1
			int lowPos=161+Math.abs(random.nextInt(93));
			
			
			byte bytehigh = new Integer(highPos).byteValue();
			byte byteLow= new Integer(lowPos).byteValue();
			
			byte[] b=new byte[2];
			b[0]=bytehigh;
			b[1]=byteLow;
			String str=null;
			try {
				str= new String(b,"GB2312");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return str;
			
		}
		//获得多个中文
		public static String getRandomChineseString(int subs) {
			StringBuffer sb=new StringBuffer();
			for(int i=0;i<subs;i++) {
				sb.append(getRandomChineseString());
			}
			
			return sb.toString();
		}

		//取名
		public static String getRandomName() {
			String[] surname = { "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦",
					"尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦",
					"章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳",
					"酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常", "乐",
					"于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹", "姚", "邵",
					"湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
					"屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭",
					"梅", "盛", "林", "刁", "钟", "徐", "邱", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝",
					"管", "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应", "宗", "丁", "宣", "贲", "邓", "郁", "单", "杭", "洪", "包", "诸",
					"左", "石", "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀", "羊", "于", "惠", "甄", "曲", "家",
					"封", "芮", "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗", "山", "谷",
					"车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲", "伊", "宫", "宁", "仇", "栾", "暴", "甘", "钭", "厉", "戎", "祖",
					"武", "符", "刘", "景", "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎", "蓟", "溥", "印", "宿", "白", "怀", "蒲", "邰",
					"从", "鄂", "索", "咸", "籍", "赖", "卓", "蔺", "屠", "蒙", "池", "乔", "阴", "郁", "胥", "能", "苍", "双", "闻", "莘", "党",
					"翟", "谭", "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦", "雍", "却", "璩", "桑", "桂", "濮", "牛", "寿", "通",
					"边", "扈", "燕", "冀", "浦", "尚", "农", "温", "别", "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习", "宦", "艾",
					"鱼", "容", "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨", "居", "衡", "步", "都", "耿", "满", "弘", "匡", "国", "文",
					"寇", "广", "禄", "阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩", "厍", "聂", "晁", "勾", "敖", "融",
					"冷", "訾", "辛", "阚", "那", "简", "饶", "空", "曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关", "蒯", "相", "查",
					"后", "荆", "红", "游", "郏", "竺", "权", "逯", "盖", "益", "桓", "公", "仉", "督", "岳", "帅", "缑", "亢", "况", "郈", "有",
					"琴", "归", "海", "晋", "楚", "闫", "法", "汝", "鄢", "涂", "钦", "商", "牟", "佘", "佴", "伯", "赏", "墨", "哈", "谯", "篁",
					"年", "爱", "阳", "佟", "言", "福", "南", "火", "铁", "迟", "漆", "官", "冼", "真", "展", "繁", "檀", "祭", "密", "敬", "揭",
					"舜", "楼", "疏", "冒", "浑", "挚", "胶", "随", "高", "皋", "原", "种", "练", "弥", "仓", "眭", "蹇", "覃", "阿", "门", "恽",
					"来", "綦", "召", "仪", "风", "介", "巨", "木", "京", "狐", "郇", "虎", "枚", "抗", "达", "杞", "苌", "折", "麦", "庆", "过",
					"竹", "端", "鲜", "皇", "亓", "老", "是", "秘", "畅", "邝", "还", "宾", "闾", "辜", "纵", "侴", "万俟", "司马", "上官", "欧阳",
					"夏侯", "诸葛", "闻人", "东方", "赫连", "皇甫", "羊舌", "尉迟", "公羊", "澹台", "公冶", "宗正", "濮阳", "淳于", "单于", "太叔", "申屠",
					"公孙", "仲孙", "轩辕", "令狐", "钟离", "宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空", "兀官", "司寇", "南门", "呼延", "子车",
					"颛孙", "端木", "巫马", "公西", "漆雕", "车正", "壤驷", "公良", "拓跋", "夹谷", "宰父", "谷梁", "段干", "百里", "东郭", "微生", "梁丘",
					"左丘", "东门", "西门", "南宫", "第五", "公仪", "公乘", "太史", "仲长", "叔孙", "屈突", "尔朱", "东乡", "相里", "胡母", "司城", "张廖",
					"雍门", "毋丘", "贺兰", "綦毋", "屋庐", "独孤", "南郭", "北宫", "王孙" };
			
			//获得姓氏
			String name1=surname[getRandomNum(surname.length-1,0)];
			//获得名字
			String  name2= getRandomChineseString(getRandomNum(2,1));
			return name1+name2;
				
				
		}
	
		/**
		 * 
		 * @Title: getRandomSex 
		 * @Description: 获取随机性别
		 * @return
		 * @return: String
		 */
		public static String getRandomSex() {
			int randomNum = getRandomNum(1, 0);
			if(randomNum==0) {
				return "男";
			}else {
				return "女";
			}
			
		}
		/**
		 * 
		 * @Title: getRandomPhone 
		 * @Description: 获取一个随机电话号码
		 * @return
		 * @return: String
		 */
		public static String getRandomPhone() {
			int startPhone = getRandomNum(9, 3);
			int endPhone = RandomUtil.getRandomNum(1000000000, 100000000);
			return "1"+startPhone+endPhone;
		}
		
		private static final String[] email_suffix = "@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn".split(",");
	    public static String base = "abcdefghijklmnopqrstuvwxyz0123456789";
	
		
		/**
		 * 
		 * @Title: getRandomEmail 
		 * @Description: 获取一个随机邮箱
		 * @return
		 * @return: String
		 */
		public static String getRandomEmail(int max,int min) {
	        int length = getRandomNum(max, min);
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < length; i++) {
	            int number = (int) (Math.random() * base.length());
	            sb.append(base.charAt(number));
	        }
	        sb.append(email_suffix[(int) (Math.random() * email_suffix.length)]);
	        return sb.toString();
		}
		/**
		 * 
		 * @Title: getRandomDate 
		 * @Description: 获取随机生日
		 * @return
		 * @return: Date
		 */
		public static Date getRandomDate(int max,int min) {
			Calendar calendar=Calendar.getInstance();
			long time = calendar.getTime().getTime();
			long longTime=(1000*60*60*24);
			int randomNum = getRandomNum(max, min);
			long time2=getRandomNum(365, 0)*longTime*randomNum;
			calendar.setTimeInMillis(time-time2);
			return calendar.getTime();
		}
		
		
		
	
}
