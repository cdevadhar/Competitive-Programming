package labs_projects;

import java.util.Scanner;

public class GuessingGame {
	static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		System.out.println("Is it a land animal?");
		String curr = in.next();
		if (curr.toLowerCase().contentEquals("yes")) {
			System.out.println("Is it a mammal?");
			curr = in.next();
			if (curr.toLowerCase().contentEquals("yes")) {
				System.out.println("Is it a predator?");
				curr = in.next();
				if (curr.toLowerCase().contentEquals("yes")) {
					System.out.println("Is it a feline?");
					curr = in.next();
					if (curr.toLowerCase().contentEquals("yes")) {
						
						System.out.println("Is it bigger than a German Shepherd?");
						curr = in.next();
						if (curr.toLowerCase().contentEquals("yes")) {
							System.out.println("Is it a lion?");
							curr = in.next();
							if (curr.toLowerCase().contentEquals("yes")) System.out.println("Yay");
							else System.out.println("Dnc bre");
						}
						else {
							System.out.println("Is it a housecat?");
							curr = in.next();
							if (curr.toLowerCase().contentEquals("yes")) System.out.println("Yay");
							else System.out.println("Dnc bre");
						}
					}
					else {
						System.out.println("Is it a canine?");
						curr = in.next();
						if (curr.toLowerCase().contentEquals("yes")) {
							System.out.println("Is it bigger than a dog?");
							curr = in.next();
							if (curr.toLowerCase().contentEquals("yes")) {
								System.out.println("Is it a wolf");
								curr = in.next();
								if (curr.toLowerCase().contentEquals("yes")) System.out.println("Yay");
								else System.out.println("Dnc");
							}
							else {
								System.out.println("Is it a dog?");
								curr = in.next();
								if (curr.toLowerCase().contentEquals("yes")) System.out.println("Yay");
								else System.out.println("Dnc");
							}
						}
						else {
							System.out.println("Is it a bear?");
							curr = in.next();
							if (curr.toLowerCase().contentEquals("yes")) System.out.println("Yay");
							else System.out.println("Dnc bre");
						}
					}
				}
				else {
					System.out.println("Does it live in Africa?");
					curr = in.next();
					if (curr.toLowerCase().contentEquals("yes")) {
						System.out.println("Does it have a long neck?");
						curr = in.next();
						if (curr.toLowerCase().contentEquals("yes")) {
							System.out.println("Is it a giraffe?");
							curr = in.next();
							if (curr.toLowerCase().contentEquals("yes")) System.out.println("Yay");
							else System.out.println("Dnc bre");
						}
						else {
							System.out.println("Is it an elephant?");
							curr = in.next();
							if (curr.toLowerCase().contentEquals("yes")) System.out.println("Yay");
							else System.out.println("Dnc bre");
						}
					}
					else {
						System.out.println("Is it a cow?");
						curr = in.next();
						if (curr.toLowerCase().contentEquals("yes")) {
							System.out.println("Yay");
						}
						else {
							System.out.println("Is it a moose?");
							curr = in.next();
							if (curr.toLowerCase().contentEquals("yes")) {
								System.out.println("Yay");
							}
							else {
								System.out.println("Dnc bre");
							}
						}
					}
				}
			}
			else {
				System.out.println("Is it a reptile?");
				curr = in.next();
				if (curr.toLowerCase().contentEquals("yes")) {
					System.out.println("Is it extinct?");
					curr = in.next();
					if (curr.toLowerCase().contentEquals("yes")) {
						System.out.println("Is it a dinosaur?");
						curr = in.next();
						if (curr.toLowerCase().contentEquals("yes")) {
							System.out.println("Yay");
						}
						else System.out.println("Dnc bre");
					}
					
					else {
						System.out.println("Is it a lizard?");
						curr = in.next();
						if (curr.toLowerCase().contentEquals("yes")) {
							System.out.println("Yay");
						}
						else {
							System.out.println("Is it a crocodile?");
							curr = in.next();
							if (curr.toLowerCase().contentEquals("yes")) {
								System.out.println("Yay");
							}
							else System.out.println("Dnc bre");
						}
					}
				}
				else {
					System.out.println("Is it a bird?");
					curr = in.next();
					if (curr.toLowerCase().contentEquals("yes")) {
						System.out.println("Is it a predator?");
						curr = in.next();
						if (curr.toLowerCase().contentEquals("yes")) {
							System.out.println("Is it an eagle?");
							curr = in.next();
							if (curr.toLowerCase().contentEquals("yes")) {
								System.out.println("Yay");
							}
							else {
								System.out.println("Is it a hawk?");
								curr = in.next();
								if (curr.toLowerCase().contentEquals("yes")) {
									System.out.println("Yay");
								}
								else System.out.println("Dnc bre");
							}
						}
						else {
							System.out.println("Does it live in Lake Elizabeth?");
							curr = in.next();
							if (curr.toLowerCase().contentEquals("yes")) {
								System.out.println("Is it a Canada goose?");
								curr = in.next();
								if (curr.toLowerCase().contentEquals("yes")) {
									System.out.println("Yay");
								}
								else {
									System.out.println("Dnc bre");
								}
							}
							else {
								System.out.println("Is it large for a bird?");
								curr = in.next();
								if (curr.toLowerCase().contentEquals("yes")) {
									System.out.println("Is it a flamingo?");
									curr = in.next();
									if (curr.toLowerCase().contentEquals("yes")) {
										System.out.println("Yay");
									}
									else {
										System.out.println("Is it an ostrich?");
										curr = in.next();
										if (curr.toLowerCase().contentEquals("yes")) {
											System.out.println("Yay");
										}
										else System.out.println("Dnc bre");
									}
								}
								else {
									System.out.println("Is it a finch?");
									curr = in.next();
									if (curr.toLowerCase().contentEquals("yes")) {
										System.out.println("Yay");
									}
									else {
										System.out.println("Is it a robin?");
										curr = in.next();
										if (curr.toLowerCase().contentEquals("yes")) {
											System.out.println("Yay");
										}
										else System.out.println("Dnc bre");
									}
								}
							}
						}
					}
					else {
						System.out.println("Is it an amphibian?");
						curr = in.next();
						if (curr.toLowerCase().contentEquals("yes")) {
							System.out.println("Is it a frog?");
							curr = in.next();
							if (curr.toLowerCase().contentEquals("yes")) {
								System.out.println("Yay");
							}
							else {
								System.out.println("Is it a salamander?");
								curr = in.next();
								if (curr.toLowerCase().contentEquals("yes")) {
									System.out.println("Yay");
								}
								else System.out.println("Dnc bre");
							}
						}
						else {
							System.out.println("Dnc bre");
						}
					}
				}
			}
			
      
		}
		else if (curr.toLowerCase().contentEquals("no")) {
			System.out.println("Is it a mammal?");
			curr = in.next();
			if (curr.toLowerCase().contentEquals("yes")) {
				System.out.println("Is it big?");
				curr = in.next();
				if (curr.toLowerCase().contentEquals("yes")) {
					System.out.println("Does it have teeth?");
					curr = in.next();
					if (curr.toLowerCase().contentEquals("yes")) {
						System.out.println("Is it an orca?");
						curr = in.next();
						if (curr.toLowerCase().contentEquals("yes")) {
							System.out.println("Yay");
						}
						else {
							System.out.println("Dnc bre");
						}
					}
					else {
						System.out.println("Is it a blue whale?");
						curr = in.next();
						if (curr.toLowerCase().contentEquals("yes")) {
							System.out.println("Yay");
						}
						else {
							System.out.println("Is it a humpback whale?");
							curr = in.next();
							if (curr.toLowerCase().contentEquals("yes")) {
								System.out.println("Yay");
							}
							else System.out.println("Dnc bre");
						}
					}
				}
				else {
					System.out.println("Is it bigger than a dog?");
					curr = in.next();
					if (curr.toLowerCase().contentEquals("yes")) {
						System.out.println("Is it a seal?");
						curr = in.next();
						if (curr.toLowerCase().contentEquals("yes")) {
							System.out.println("Yay");
						}
						else System.out.println("Dnc");
					}
					else {
						System.out.println("Is it an otter?");
						curr = in.next();
						if (curr.toLowerCase().contentEquals("yes")) {
							System.out.println("Yay");
						}
						else System.out.println("Dnc");
					}
				}
			}
			else {
				System.out.println("Is it a fish?");
				curr = in.next();
				if (curr.toLowerCase().contentEquals("yes")) {
					System.out.println("Is it a large predator?");
					curr = in.next();
					if (curr.toLowerCase().contentEquals("yes")) {
						System.out.println("Is it a great white shark?");
						curr = in.next();
						if (curr.toLowerCase().contentEquals("yes")) {
							System.out.println("Yay");
						}
						else System.out.println("Dnc bre");
					}
					else {
						System.out.println("Does it go in rivers?");
						curr = in.next();
						if (curr.toLowerCase().contentEquals("yes")) {
							System.out.println("Is it a salmon?");
							curr = in.next();
							if (curr.toLowerCase().contentEquals("yes")) {
								System.out.println("Yay");
							}
							else System.out.println("Dnc bre");
						}
						else {
							System.out.println("Is it a clownfish?");
							curr = in.next();
							if (curr.toLowerCase().contentEquals("yes")) {
								System.out.println("Yay");
							}
							else System.out.println("Dnc bre");
						}
					}
					
				}
				else {
					System.out.println("Does it move?");
					curr = in.next();
					if (curr.toLowerCase().contentEquals("yes")) {
						System.out.println("Is it a penguin?");
						curr = in.next();
						if (curr.toLowerCase().contentEquals("yes")) {
							System.out.println("Yay");
						}
						else {
							System.out.println("Dnc");
						}
					}
					else {
						System.out.println("Is it a coral?");
						curr = in.next();
						if (curr.toLowerCase().contentEquals("yes")) {
							System.out.println("Yay");
						}
						else {
							System.out.println("Is it a sea cucumber?");
							curr = in.next();
							if (curr.toLowerCase().contentEquals("yes")) {
								System.out.println("Yay");
							}
							else System.out.println("Dnc");
						}
					}
					
				}
			}
			

		}
    else {
      System.out.println("You're too dumb to play this game.");
    }
	}
}
