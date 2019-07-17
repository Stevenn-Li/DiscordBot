package disc.StevenBot;

import java.util.Random;
import java.util.Timer;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Roll extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event){
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
			
		if (args[0].equalsIgnoreCase("~roll") && args.length == 2 && Integer.parseInt(args[1]) >= 1){
			Random rand = new Random();
			int randNum = rand.nextInt(Integer.parseInt(args[1])) + 1;
			event.getChannel().sendMessage("You have rolled a " + randNum +  ".").queue();
			
			//Integer.MAX, 
		}  
		/*
		else if ((args[0].equalsIgnoreCase("~roll") && args[1].contains(".")) ||
				(args[0].equalsIgnoreCase("~roll") && (Integer.parseInt(args[1]) < 1)))
				 { */
		else if (args[0].equalsIgnoreCase("~roll")){
			event.getChannel().sendMessage("Please enter an integer greater than 0.").queue();
		}	
		else{
			
		}
	}
}
