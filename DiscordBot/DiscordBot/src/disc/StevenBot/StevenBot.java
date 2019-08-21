package disc.StevenBot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

public class StevenBot {
	public static String prefix = "~";
	
	
	public static void main(String[] args) throws LoginException{
		JDABuilder builder = new JDABuilder();
		builder.setToken("");
		builder.setStatus(OnlineStatus.IDLE);
		builder.setGame(Game.playing("Work in Progress"));
		builder.addEventListener(new Commands());
		builder.addEventListener(new Clear());
		builder.addEventListener(new GuildMemberJoin());
		builder.addEventListener(new GuildMemberLeave());
		builder.addEventListener(new GuildMessageReceived());
		builder.addEventListener(new Reminder());
		builder.addEventListener(new Roll());
		builder.build();
		
	}
}
