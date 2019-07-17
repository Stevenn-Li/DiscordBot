package disc.StevenBot;

import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import java.util.Timer;

public class Reminder extends ListenerAdapter{
	
	public void Remind(GuildMessageReceivedEvent event){
		
	String[] args = event.getMessage().getContentRaw().split("\\s+");
	
	
	if (args[0].equalsIgnoreCase("~remind") ){
		System.out.println("hello");
		EmbedBuilder reminder = new EmbedBuilder();
		reminder.setTitle("Reminder: " + args[1]);
		reminder.setDescription("Time Duration: " + args[2]);
		reminder.setColor(0x6f42f5);
		event.getChannel().sendMessage(reminder.build()).queue();
		Timer timer = new Timer();
		timer.schedule(
				new java.util.TimerTask(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						EmbedBuilder reminded = new EmbedBuilder();
						reminded.setTitle("Reminder for: " + args[1]);
						reminded.setColor(0x6f42f5);
						event.getChannel().sendMessage(reminded.build()).queue();
					}
				}, Integer.parseInt(args[2])*1000);
	}
	else{
		event.getChannel().sendMessage("Incorrect Syntax. Use ~remind [Description] [time amount]").queue();

	} 
	
	}
}
