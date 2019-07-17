package disc.StevenBot;

import java.util.Random;
import java.util.Timer;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event){
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if(args[0].equalsIgnoreCase(StevenBot.prefix + "info")){
			
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("Steven's Slave :)");
			info.setDescription("Testing information description");
			info.setColor(0x4287f5);
			info.setFooter("User Information",event.getMember().getUser().getAvatarUrl());
			//event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();
			info.clear();
			//event.getChannel().sendTyping().complete();
		}
		
		
		
	}
}
