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
		
		//String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		
		if (args[0].equalsIgnoreCase("~remind") && args.length == 3){
			
			EmbedBuilder reminder = new EmbedBuilder();
			reminder.setTitle("Reminder: " + args[1]);
			reminder.setDescription("Time Duration: " + args[2] + " seconds.");
			reminder.setColor(0xa442f5);
			event.getChannel().sendMessage(reminder.build()).queue();
			Timer timer = new Timer();
			timer.schedule(
					new java.util.TimerTask(){
						@Override
						public void run() {
							// TODO Auto-generated method stub
							EmbedBuilder reminded = new EmbedBuilder();
							reminded.setTitle("Reminder for: " + args[1] + " complete.");
							reminded.setColor(0xf542ec);
							event.getChannel().sendMessage(reminded.build()).queue();
						}
					}, Integer.parseInt(args[2])*1000);
		}
		if (args[0].equalsIgnoreCase("~remind") && args.length < 3){
			event.getChannel().sendMessage("Incorrect Syntax. Use ~remind [Description] [time amount]").queue();
		} 
		
		if (args[0].equalsIgnoreCase("~roll")){
			Random rand = new Random();
			int randNum = rand.nextInt(Integer.parseInt(args[1])) + 1;
			event.getChannel().sendMessage("You have rolled a " + randNum +  ".").queue();
			//conditions such as Rolling a 0 or negative number, and Integer.MAX, 
			//also make sure is an integer, cant roll doubles
		}
	}
}
