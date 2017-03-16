<?php

namespace GarderieBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * responsableLegal
 *
 * @ORM\Table(name="responsable_legal")
 * @ORM\Entity(repositoryClass="GarderieBundle\Repository\responsableLegalRepository")
 */
class responsableLegal
{
    /**
    * @ORM\ManyToOne(targetEntity="GarderieBundle\Entity\tarif")
    * @ORM\JoinColumn(nullable=false)
    */
    private $tarif;

    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=255)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="prenom", type="string", length=255)
     */
    private $prenom;

    /**
     * @var string
     *
     * @ORM\Column(name="telephone", type="string", length=255)
     */
    private $telephone;

    /**
     * @var string
     *
     * @ORM\Column(name="QF", type="string", length=255)
     */
    private $qF;


    /**
     * Get id
     *
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set nom
     *
     * @param string $nom
     *
     * @return responsableLegal
     */
    public function setNom($nom)
    {
        $this->nom = $nom;

        return $this;
    }

    /**
     * Get nom
     *
     * @return string
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * Set prenom
     *
     * @param string $prenom
     *
     * @return responsableLegal
     */
    public function setPrenom($prenom)
    {
        $this->prenom = $prenom;

        return $this;
    }

    /**
     * Get prenom
     *
     * @return string
     */
    public function getPrenom()
    {
        return $this->prenom;
    }

    /**
     * Set telephone
     *
     * @param string $telephone
     *
     * @return responsableLegal
     */
    public function setTelephone($telephone)
    {
        $this->telephone = $telephone;

        return $this;
    }

    /**
     * Get telephone
     *
     * @return string
     */
    public function getTelephone()
    {
        return $this->telephone;
    }

    /**
     * Set qF
     *
     * @param string $qF
     *
     * @return responsableLegal
     */
    public function setQF($qF)
    {
        $this->qF = $qF;

        return $this;
    }

    /**
     * Get qF
     *
     * @return string
     */
    public function getQF()
    {
        return $this->qF;
    }

    /**
     * Set tarif
     *
     * @param \OC\GarderieBundle\Entity\tarif $tarif
     *
     * @return responsableLegal
     */
    public function setTarif(\OC\GarderieBundle\Entity\tarif $tarif)
    {
        $this->tarif = $tarif;

        return $this;
    }

    /**
     * Get tarif
     *
     * @return \OC\GarderieBundle\Entity\tarif
     */
    public function getTarif()
    {
        return $this->tarif;
    }
}
